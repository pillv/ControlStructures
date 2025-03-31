import kotlin.math.max

fun main() {
    transaction("Mastercard", 450, 90000)
    transaction("Visa", 7000000, 85000)
    transaction("Visa", 70000, 85000)
}
fun transaction (card: String, transfersEarlier: Int = 0, amount: Int){
    var commission = when (card) {
        "Mastercard" -> if (transfersEarlier+amount<= 75000) 0 else (transfersEarlier+amount - 75000)*0.0006+20
        "Visa" -> max(amount*0.0075, 35.0)
        else -> 0
    }
    var totalAmount = amount + commission.toFloat()
    var message = when {
        (amount > 150000 || transfersEarlier+amount > 6000000) -> "Операция отклонена. Превышен лимит переводов"
        else -> "$amount рублей успешно переведено с карты $card\nкомиссия - $commission рублей \nc карты списано - $totalAmount рублей"
    }
    println(message)
    println()
}