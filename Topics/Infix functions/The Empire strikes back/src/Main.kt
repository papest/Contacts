infix fun List<Ship>.battle(ammunitionLimit: Int): List<String> =
    this.filter { it.ammunition > ammunitionLimit }.map { it.name }
