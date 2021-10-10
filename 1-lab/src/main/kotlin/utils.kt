import java.lang.StringBuilder

// Выравнивание текста по заданному параметру
fun alignText(
    text: String,
    alignment: Alignment = Alignment.LEFT,
    lineWidth: Int = 87
): String{
    var splittedText : MutableList<String> = splitTextByWidth(text, lineWidth)

    when (alignment){
        Alignment.LEFT    -> splittedText = leftAlign(splittedText, lineWidth)
        Alignment.RIGHT   -> splittedText = rightAlign(splittedText, lineWidth)
        Alignment.CENTER  -> splittedText = centerAlign(splittedText, lineWidth)
        else              -> splittedText = justifyAlign(splittedText, lineWidth)
    }

    return splittedText.convertToString("\n");
}

//Функция для разбивки текста по ширине страницы
public fun splitTextByWidth (
    textToSplit : String,
    lineWidth : Int
) : MutableList<String>{
    var localText = textToSplit // Текст для локального изменения
    var splittedText : MutableList<String> = arrayListOf() // Массив распределенных строк
    var temp : String = String() // Строка для промежуточных действий

    // Выполняем данный алгоритм, пока строка строка с локальным текстом не закончится
    while (localText.length > 0) {
        temp = localText.safeSubstring(0, lineWidth).trim() // Берем часть из начала localText
        // Проверка: если текст не состоит из одного слова и первое слово общей строки <= lineWidth
        if (localText.indexOf(' ') != -1 && localText.substring(0, localText.indexOf(' ')).length <= lineWidth)
        {
            if (localText.length == temp.length || localText[temp.length] == ' ') // Если строка полностью влезает в указанную ширину,
                splittedText.add(temp)  // тогда добавляем её в результирующий текст
            else // Иначе в результирующий текст пойдет только то, что влезло до последнего пробела
            {
                temp = temp.substring(0, temp.lastIndexOf(' ')) // Изменяем промежуточную строку, чтобы в конце итерации удалить нужную длину
                splittedText.add(temp)
            }
        }
        else // Если первое слово строки > lineWidth,
            splittedText.add(temp) // тогда добавляем часть строки, которая вместится в ширину страницы

        // Удаляем обработанную часть из локального текста
        localText = localText.safeSubstring(temp.length, localText.length).trim()
    }
    return splittedText
}

fun leftAlign(splittedText : MutableList<String>, lineWidth: Int) : MutableList<String>
{
    for (i in 0..splittedText.size - 1)
        splittedText[i] = splittedText[i].trim()
    return  splittedText
}

fun rightAlign(splittedText : MutableList<String>, lineWidth: Int) : MutableList<String>
{
    for (i in 0..splittedText.size - 1)
        splittedText[i] = splittedText[i].padStart(lineWidth)
    return  splittedText
}

fun centerAlign(splittedText : MutableList<String>, lineWidth: Int) : MutableList<String>
{
    for (i in 0..splittedText.size - 1){
        var stringLen = splittedText[i].length // Длина текущей строки
        var indent = stringLen + (lineWidth - stringLen)/2 // Отступ от левого края для выравнивания по центру
        splittedText[i] = splittedText[i].padStart(indent)
    }
    return  splittedText
}

fun justifyAlign(splittedText : MutableList<String>, lineWidth: Int) : MutableList<String>
{
    for (i in 0..splittedText.size - 1){
        splittedText[i] = splittedText[i].trim()
        var wordCount = splittedText[i].count{x -> x == ' '} + 1 // Количество слов в строке
        var noSpaceStringLen = splittedText[i].count{x -> x != ' '} // Длина текущей строки без пробелов

        if (wordCount != 1){
            var spaceSize = (lineWidth - noSpaceStringLen) / (wordCount - 1)
            splittedText[i] = splittedText[i].replace(" ", " ".repeat(spaceSize))
//            if (splittedText[i].length != lineWidth) splittedText[i] = splittedText[i].replace(" ", "  ")
        }
    }
    return  splittedText
}

// Добавляет в конец каждого объекта списка указанную строку
// после чего объединяет весь массив в одну строку
fun MutableList<String>.convertToString(addition : String = "") : String
{
    var sb : StringBuilder = StringBuilder()

    for (i in 0..this.size - 1)
        sb.append(this[i].plus(addition))

    return sb.toString()
}

// Взятие максимально возможной подстроки для избежания возникновения исключений
fun String.safeSubstring(startIndex : Int, endIndex : Int) : String
{
    if (this.length < endIndex) return this.substring(startIndex, (endIndex - (endIndex - this.length )))
    else return this.substring(startIndex, endIndex) // Обычное взятие подстроки
}