import java.lang.StringBuilder

// Выравнивание текста по заданному параметру
fun alignText(
    text: String,
    alignment: Alignment = Alignment.LEFT,
    lineWidth: Int = 87
): String {
    if (lineWidth < 1) throw IllegalArgumentException("Line width argument can't be less than 1")

    var splittedText: MutableList<String> = splitTextByWidth(text, lineWidth)

    splittedText = when (alignment) {
        Alignment.LEFT -> leftAlign(splittedText)
        Alignment.RIGHT -> rightAlign(splittedText, lineWidth)
        Alignment.CENTER -> centerAlign(splittedText, lineWidth)
        Alignment.JUSTIFY -> justifyAlign(splittedText, lineWidth)
    }

    return splittedText.convertToString()
}

//Функция для разбивки текста по ширине страницы
fun splitTextByWidth(
    textToSplit: String,
    lineWidth: Int
): MutableList<String> {
    var localText = textToSplit // Текст для локального изменения
    val splittedText: MutableList<String> = arrayListOf() // Массив распределенных строк
    var temp: String // Строка для промежуточных действий

    // Выполняем данный алгоритм, пока строка строка с локальным текстом не закончится
    while (localText.isNotEmpty()) {
        temp = localText.safeSubstring(0, lineWidth).trim() // Берем часть из начала localText
        // Проверка: если текст не состоит из одного слова и длина первого слова локального текста <= lineWidth
        if (localText.indexOf(' ') != -1 && localText.substring(0, localText.indexOf(' ')).length <= lineWidth) {
            if (localText.length == temp.length || localText[temp.length] == ' ') // Если строка полностью влезает в указанную ширину,
                splittedText.add(temp)  // тогда добавляем её в результирующий текст
            else // Иначе в результирующий текст пойдет только то, что влезло до последнего пробела
            {
                temp = temp.substring(
                    0,
                    temp.lastIndexOf(' ')
                ) // Изменяем промежуточную строку, чтобы в конце итерации удалить нужную длину
                splittedText.add(temp)
            }
        } else // Если первое слово строки > lineWidth,
            splittedText.add(temp) // тогда добавляем часть строки, которая вместится в ширину страницы

        // Удаляем обработанную часть из локального текста
        localText = localText.safeSubstring(temp.length, localText.length).trim()
    }
    return splittedText
}

private fun leftAlign(splittedText: MutableList<String>): MutableList<String> {
    for (i in 0 until splittedText.size)
        splittedText[i] = splittedText[i].trim()
    return splittedText
}

private fun rightAlign(splittedText: MutableList<String>, lineWidth: Int): MutableList<String> {
    for (i in 0 until splittedText.size)
        splittedText[i] = splittedText[i].padStart(lineWidth)
    return splittedText
}

private fun centerAlign(splittedText: MutableList<String>, lineWidth: Int): MutableList<String> {
    for (i in 0 until splittedText.size) {
        val stringLen = splittedText[i].length
        val indent = stringLen + (lineWidth - stringLen) / 2 // Отступ от левого края для выравнивания по центру
        splittedText[i] = splittedText[i].padStart(indent)
    }
    return splittedText
}

private fun justifyAlign(splittedText: MutableList<String>, lineWidth: Int): MutableList<String> {
    for (i in 0 until splittedText.size) {
        splittedText[i] = splittedText[i].trim()
        val wordCount = splittedText[i].count { x -> x == ' ' } + 1 // Количество слов в строке
        val noSpaceStringLen = splittedText[i].count { x -> x != ' ' } // Длина текущей строки без пробелов

        if (wordCount != 1) {
            val spaceSize = (lineWidth - noSpaceStringLen) / (wordCount - 1)
            splittedText[i] = splittedText[i].replace(" ", " ".repeat(spaceSize))
        }
    }
    return splittedText
}

// Добавляет в конец каждого объекта списка указанную строку
// после чего объединяет весь массив в одну строку
private fun MutableList<String>.convertToString(separator: String = "\n"): String {
    val sb = StringBuilder()

    for (i in 0 until this.size)
        if (i == this.size - 1) // Если последняя строка в массиве, тогда не добавляем разделитель в конец
            sb.append(this[i])
        else
            sb.append(this[i].plus(separator))

    return sb.toString()
}

// Взятие максимально возможной подстроки для избежания возникновения исключений
private fun String.safeSubstring(startIndex: Int, endIndex: Int): String {
    if (this.length < endIndex) return this.substring(startIndex, (endIndex - (endIndex - this.length)))
    else return this.substring(startIndex, endIndex) // Обычное взятие подстроки
}