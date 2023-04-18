fun main() {
    val size = readln().toInt()
    val list = List(size) { readln().toInt() }
    val max = list.maxOrNull()?.toInt()
    println(list.indexOf(max))
}