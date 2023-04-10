infix fun List<Int>.matrix(code: Int): Int = this.filter { it % code == 0 }.sum()
