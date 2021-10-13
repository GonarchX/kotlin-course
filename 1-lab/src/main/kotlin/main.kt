import java.lang.Exception

fun main (){
    var inputString : String = "Везет Сенька Саньку с Сонькой на санках. Санки скок, Сеньку с ног, Соньку в лоб, все - в сугроб."
    var result = alignText(inputString, Alignment.CENTER, 10)
    print(result)
}