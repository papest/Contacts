class MyStack<T>(data: List<T>) {
    private val items = data.toMutableList()

    fun push(data: T) {
        items.add(0, data)
    }

    fun pop(): T = items.removeFirst()
}
