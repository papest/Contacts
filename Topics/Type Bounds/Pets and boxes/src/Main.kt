class Box<T : Animal> {
    private val list = mutableListOf<T>()
    fun add(animal: T) {
        list.add(animal)
    }

    fun isEmpty(): Boolean = list.isEmpty()
}

open class Animal
class Cat : Animal()