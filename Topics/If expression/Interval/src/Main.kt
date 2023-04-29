val FIRST_RANGE = -14..12
val SECOND_RANGE = 15..16
const val THIRD = 19
fun main() {
    val number = readln().toInt()
    println(if (number >= THIRD || number in FIRST_RANGE || number in SECOND_RANGE) "True" else "False")
}