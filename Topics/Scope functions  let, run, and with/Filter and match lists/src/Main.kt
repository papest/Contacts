fun main() {
    val domains = readln().split(" ")
    val map = domains.run {
        val map = mutableMapOf<String, String>()
        forEach {
            map[it.lowercase()] = "[${it.length}]"
        }
        map
    }
    println(domains.size)
    println(map)
}