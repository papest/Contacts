import kotlin.math.max

fun main() {
    val array = Array(readln().toInt()) { readln().toInt() }

    var maxSize = 1
    var currSize = 0

    if (array.size < 2) {
        println(array.size)
        return
    }

    var last = array[0]

    for (current in array) {
        if (current < last) {
            currSize = 1
            last = current
            continue
        } else {
            currSize++
            maxSize = max(currSize, maxSize)
            last = current
        }
    }
    println(maxSize)
}