import kotlinx.datetime.daysUntil
import kotlinx.datetime.toLocalDate

fun daysDifference(date1: String, date2: String): Int =
    kotlin.math.abs(date1.toLocalDate().daysUntil(date2.toLocalDate()))

fun main() {
    val date1 = readLine()!!
    val date2 = readLine()!!
    println(daysDifference(date1, date2))
}