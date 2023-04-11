fun sum(p1: Pair<Int, Int>, p2: Pair<Int, Int>): Pair<Int, Int> = Pair(p1.first + p2.first, p1.second + p2.second)

fun main() {
    val (a, b) = readLine()!!.split(' ').map { it.toInt() }
    val (c, d) = readLine()!!.split(' ').map { it.toInt() }
    val pairOne = Pair(a, b)
    val pairTwo = Pair(c, d)
    println(sum(pairOne, pairTwo))
}