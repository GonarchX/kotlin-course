const val G_lineWidth : Int = 10

fun main (){
    var inputString : String = "Везет Сенька Саньку с Сонькой на санках. Санки скок, Сеньку с ног, Соньку в лоб, все - в сугроб."

//    var inputString : String = "aaaaa"
    inputString.trim()

    //Проверка: первое слово общей строки <= lineWidth
    //Да: Берем подстроку длиной в ширину страницы и проверяем
    //Нет: обрезаем

    var resultText : MutableList<String> = splitTextByWidth(inputString, G_lineWidth)

//    .indexOfLast { x -> x != ' ' }
//    println("  asdf".indexOfLast { x -> x != ' ' })
    /*for (i in 0..resultText.size - 1)
        println(resultText[i].padStart(G_lineWidth)) // Правое выравнивание
    for (string in resultText) println("$string")*/

    for (i in 0..resultText.size - 1){
        var stringLen = resultText[i].length // Длина текущей строки
        var indent = stringLen + (G_lineWidth - stringLen)/2 // Отступ от левого края для выравнивания по центру
        println(resultText[i].padStart(indent))
    }
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