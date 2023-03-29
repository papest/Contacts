fun main() {
    val size = readln().toInt()
    val array = IntArray(size)
    for (i in array.indices) {
        array[i] = readln().toInt()
    }
    var tripleCount = 0
    for (i in 1 until array.lastIndex) {
        if (array[i] - 1 == array[i - 1] && array[i + 1] == array[i] + 1) tripleCount++
    }
    println(tripleCount)
}