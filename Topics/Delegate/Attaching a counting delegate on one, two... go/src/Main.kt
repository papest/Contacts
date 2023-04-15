interface ICounter {
    var count: Int
    fun increaseCount()
    fun getCurrentCount(): Int
}

class Counter(override var count: Int) : ICounter {
    // In case we need to count differently, this function can be altered
    override fun increaseCount() {
        count++
    }

    override fun getCurrentCount(): Int = count
}

class Iterator(counter: Counter) : ICounter by counter {
    fun next() = increaseCount()
}

fun main() {
    val a = readln().toInt()

    // Set initial value to counter
    val counter = Counter(a)

    // Create iterator
    val it = Iterator(counter)

    // Do some test iterations
    for (i in 1..5) {
        it.next()
    }

    println(it.getCurrentCount())
}