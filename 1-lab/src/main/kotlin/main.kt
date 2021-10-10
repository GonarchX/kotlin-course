fun main (){
//    var inputString : String = "Везет Сенька Саньку с Сонькой на санках. Санки скок, Сеньку с ног, Соньку в лоб, все - в сугроб."

//    var inputString : String = "aaaaaaabaaaaabaaaaaaa"

    var inputString = "a a a a a"
    print(alignText(inputString, Alignment.JUSTIFY, 10))

//    println(alignText(inputString, Alignment.LEFT, 7))
//    val count = "abaa".count{x -> x != 'a'}
//    print(count)
}

fun test(inputString : String, lineWidth : Int) : String{
    var localString = inputString.trim()
    var wordCount = localString.count{x -> x == ' '} + 1 // Количество слов в строке
    var noSpaceStringLen = localString.count{x -> x != ' '} // Длина текущей строки без пробелов

    if (wordCount != 1){
        var spaceSize = (lineWidth - noSpaceStringLen) / (wordCount - 1)
        localString = localString.replace(" ", " ".repeat(spaceSize))
    }
    return localString
}