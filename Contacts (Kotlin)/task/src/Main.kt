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
            "count" to book::count,
            "edit" to book::edit,
            "remove" to book::remove,
            "info" to book::info
        )
        while (true) {
            val action = "Enter action (add, remove, edit, count, info, exit):".answer()
            if (action == "exit") break
            val a = menuMap[action] as KFunction0<Unit>
            a()
            println()
        }
    }
}

fun main() {
    Application.menu()
}
