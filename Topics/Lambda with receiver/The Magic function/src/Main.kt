fun String.magic(init: String.() -> String): String = this.init()

fun main() {
    val str = readLine()!!
    val res = str.magic {
        uppercase().reversed().dropLast(1)
    }
    println(res)
}