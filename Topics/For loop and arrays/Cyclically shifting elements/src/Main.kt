fun main() {
    val size = readln().toInt()
    val array = IntArray(size) { readln().toInt() }
    val arrayDest = IntArray(size)
    array.copyInto(arrayDest, 1, 0, array.lastIndex)
    arrayDest[0] = array.last()
    println(arrayDest.joinToString(" "))
}