fun main() {
    println("Elvis says: ${readlnOrNull() ?: throw IllegalStateException()}")
}