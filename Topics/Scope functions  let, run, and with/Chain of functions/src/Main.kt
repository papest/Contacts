data class Musician(var name: String = "", var band: String = "", var role: String = "")
@SuppressWarnings("MagicNumber")
fun main() {
    val musician = Musician()

    musician.apply {
        name = readln()
        band = readln()
        role = readln()
    }

    val num = with(musician) {
        println(this)
        name.length
    }.run {
        println(this / 4)
        this / 4
    }.let {
        it + 10
    }

    println(num)

}