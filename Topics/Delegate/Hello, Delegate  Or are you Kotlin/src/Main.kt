interface IConsolePrinter {
    val message: String
    fun printMessage()
}

class BasicConsolePrinter(val x: String, val y: String) : IConsolePrinter {
    override val message: String
        get() = "$x $y"

    override fun printMessage() {
        print("Hello Kotlin")
    }
}

class DerivedConsolePrinter(base: IConsolePrinter) : IConsolePrinter by base {
    override fun printMessage() {
        print(message)
    }
}

fun main() {
    val h = "Hello"
    val d = "Delegate"
    val k = "Kotlin"
    val delegate = BasicConsolePrinter(h, d)
    val printer = DerivedConsolePrinter(delegate)
    printer.printMessage()
}