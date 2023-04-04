import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.plus
import kotlinx.datetime.toLocalDate

fun daysForward(date: String, days: Int) = println(date.toLocalDate().plus(days, DateTimeUnit.DAY))

fun main() {
    val date = readLine()!!
    val days = readLine()!!.toInt()
    daysForward(date, days)
}