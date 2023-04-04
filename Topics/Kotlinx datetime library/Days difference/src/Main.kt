import kotlinx.datetime.*
import kotlin.time.Duration
import kotlin.time.DurationUnit

fun howManyDays(year1: Int, month1: Int, day1: Int, year2: Int, month2: Int, day2: Int): Int {

    val difference: Duration =
        Instant.parse("$year2-${String.format("%02d", month2)}-${String.format("%02d", day2)}T00:00:00Z") -
            Instant.parse("$year1-${String.format("%02d", month1)}-${String.format("%02d", day1)}T00:00:00Z")
    return difference.toInt(DurationUnit.DAYS)
}

fun main() {
    val (year1, month1, day1) = readln().split(" ").map { it.toInt() }
    val (year2, month2, day2) = readln().split(" ").map { it.toInt() }

    println(howManyDays(year1, month1, day1, year2, month2, day2))
}