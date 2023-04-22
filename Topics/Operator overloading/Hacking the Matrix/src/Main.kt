operator fun List<Int>.invoke(code: Int): Int = filter { it % code == 0 }.sum()
