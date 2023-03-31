fun main() {
    val argument = readLine()!!
    println(check(argument)?.length ?: 0)
}

fun check(name: String): String? {
    return if (name.length > 5) null else name
}