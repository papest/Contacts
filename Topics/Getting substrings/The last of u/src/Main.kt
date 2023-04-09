fun capitalizeAfterLastU(a: String) = if (a.lastIndexOf('u') == -1) {
    a
} else {
    a.substringBeforeLast('u') + 'u' +
            a.substringAfterLast('u').uppercase()
}

fun main() {
    val string = readln()
    println(capitalizeAfterLastU(string))
}