fun main() {
    println(isTriangle(readInt(), readInt(), readInt()))
}

fun readInt() = readln().toInt()

fun isTriangle(a: Int, b: Int, c: Int): String {
    return if (a + b <= c || a + c <= b || c + b <= a) "NO" else "YES"
}