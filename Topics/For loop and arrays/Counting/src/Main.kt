fun main() {
    val n = readln().toInt()
    val array = IntArray(n) { readln().toInt() }
    val m = readln().toInt()
    println(array.count { it == m })
}