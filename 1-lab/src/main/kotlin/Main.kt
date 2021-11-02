import java.lang.Exception

fun main() {
    val inputString =
        "Везет Сенька Саньку с Сонькой на санках. Санки скок, Сеньку с ног, Соньку в лоб, все - в сугроб."
    val result = alignText(inputString, Alignment.CENTER, 10)
    print(result)
}