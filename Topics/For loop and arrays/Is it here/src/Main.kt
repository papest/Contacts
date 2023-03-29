fun main() {
    val n = readln().toInt()
    val array = IntArray(n)
    for (i in array.indices) {
        array[i] = readln().toInt()
    }
    val el = readln().toInt()
    println(if (array.contains(el)) "YES" else "NO")
}