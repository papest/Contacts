fun main() {
    val poet: String? = readln()
    val coolScope = poet?.let {
        val count = poet.count { it == 'a' || it == 'A' }
        "Our poet is $it\n$count"
    }
    println(coolScope)
}