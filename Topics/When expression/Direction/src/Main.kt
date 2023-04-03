import java.lang.Exception

const val STAY = 0
const val UP = 1
const val DOWN = 2
const val LEFT = 3
const val RIGHT = 4

fun main() {
    val number = readln()
    println(
        try {
            when (number.toInt()) {
                STAY -> "do not move"
                UP -> "move up"
                DOWN -> "move down"
                LEFT -> "move left"
                RIGHT -> "move right"
                else -> "error!"
            }
        } catch (e: Exception) {
            "error!"
        }
    )
}