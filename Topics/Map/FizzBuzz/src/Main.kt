@SuppressWarnings("MagicNumber")
fun iterator(map: Map<String, Int>) {
    for (number in map.values) {
        println(
            when {
                number % 3 == 0 -> "Fizz"
                number % 5 == 0 -> "Buzz"
                else -> "FizzBuzz"
            }
        )
    }
}