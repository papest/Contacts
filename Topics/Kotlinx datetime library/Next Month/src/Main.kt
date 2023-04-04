import kotlinx.datetime.*

fun nextMonth(date: String): String = Instant.parse(date).plus(1, DateTimeUnit.MONTH, TimeZone.UTC).toString()

fun main() {
    val date = readln()
    println(nextMonth(date))
}