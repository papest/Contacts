@SuppressWarnings("All")
class Container<T>(t: T) {
    var value = t
}

fun main() {
    val container = Container("Good job!")
    println(container.value)
}