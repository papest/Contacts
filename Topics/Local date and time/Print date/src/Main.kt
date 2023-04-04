import kotlinx.datetime.toLocalDate

fun printDate(date: String) {
    val lD = date.toLocalDate()
    println("${lD.dayOfWeek}, ${lD.month} ${lD.dayOfMonth}, ${lD.year}")
}

fun main() {
    val date = readln()
    printDate(date)
}