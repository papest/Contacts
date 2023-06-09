@SuppressWarnings("All")
class Player(val id: Int, val name: String, val hp: Int) {
    companion object {
        private var id = 0
        fun create(name: String): Player = Player(++id, name, 100)
    }
}