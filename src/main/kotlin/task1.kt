fun main() {
    agoToText(45)
    agoToText(250)
    agoToText(35000)
    agoToText(200000)
    agoToText(20000000)
}

fun agoToText(time: Int) {
    val minutes = time / 60
    val hour = minutes / 60
    val day = hour / 24
    val message = when {
        (time >= 0 && time < 60) -> "был(а) только что"
        (minutes >= 1 && minutes < 60) -> {
            when (minutes) {
                1, 21, 31, 41, 51 -> "был(а) $minutes минуту назад"
                2, 22, 32, 42, 52, 3, 23, 33, 43, 53, 4, 24, 34, 44, 54 -> "был(а) $minutes минуты назад"
                else -> "был(а) $minutes минут назад"
            }
        }
        (hour >= 1 && hour < 24) -> {
            when (hour) {
                1, 21 -> "был(а) $hour час назад"
                2, 3, 4, 22, 23, 24 -> "был(а) $hour часа назад"
                else -> "был(а) $hour часов назад"
            }
        }
        (day >= 1 && day < 2) -> "был(а) вчера"
        (day >= 2 && day < 3) -> "был(а) позавчера"
        else -> "был(а) давно"
    }
    println(message)
}