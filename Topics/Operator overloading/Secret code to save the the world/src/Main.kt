operator fun List<String>.contains(limit: Int): Boolean = this.any { it.length > limit }