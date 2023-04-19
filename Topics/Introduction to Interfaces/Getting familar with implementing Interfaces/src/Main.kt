interface Animal {
    val numberOfLimbs: Int
    fun move()
    fun communicate(): String
}

fun bark(): String {
    return "bark"
}

fun meow(): String {
    return "meow"
}

fun speak(): String {
    return "speak"
}

fun walk() {
    println("walk")
}

fun fly() {
    println("fly")
}

fun swim() {
    println("swim")
}

@SuppressWarnings("MagicNumber")
class Dog : Animal {
    override val numberOfLimbs: Int = 4

    override fun move() = walk()

    override fun communicate() = bark()
}