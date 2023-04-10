infix fun List<String>.secret(limit: Int): Int = this.map { it.length }.filter { it > limit }.sum()
