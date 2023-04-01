package contacts

import kotlin.reflect.KFunction0

fun String.answer(): String {
    print(this)
    return readln()
}

object Application {
    fun menu() {
        val book = PhoneBook()
        val menuMap = mapOf(
            "add" to book::add,
            "list" to book::list,
            "count" to book::count,
            "edit" to book::edit,
            "remove" to book::remove
        )
        while (true) {
            val action = "Enter action (add, remove, edit, count, list, exit):".answer()
            if (action == "exit") break
            val a = menuMap[action] as KFunction0<Unit>
            a()
        }
    }
}

fun main() {
    Application.menu()
}
