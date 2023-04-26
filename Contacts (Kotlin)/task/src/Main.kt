package contacts

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.io.File
import kotlin.reflect.KFunction0

fun String.answer(): String {
    print(this)
    return readln()
}

fun String.isInt(): Boolean {
    return this.matches("\\d+".toRegex())
}

class Application(private val book: PhoneBook) {
    fun menu(vararg actions: String = arrayOf("add", "list", "search", "count", "exit")) {

        val menuMap = mapOf(
            "add" to book::add,
            "count" to book::count,
            "edit" to book::edit,
            "remove" to book::remove,
            "list" to book::list,
            "search" to book::search,
            "record" to book::info,
            "menu" to Application::menu,
            "again" to book::search,
        )

        while (true) {

            val action = enterAction(actions.toList())
            when {
                action == "exit" -> break
                action == "back" && actions.contains("back") -> return
                actions.contains("record") && action.isInt() -> {

                }
                actions.contains(action) -> {
                    val a = menuMap[action] as KFunction0<Unit>
                    a()
                    println()
                }

                else -> continue
            }
        }
    }
}

fun enterAction(actions: List<String>, name: String = "menu"): String {
    println()
    return "[$name] Enter action (${actions.joinToString()}):".answer()
}

fun main(args: Array<String>) {
    val book = if (args.isEmpty()) PhoneBook() else {
        PhoneBookFile.readPhoneBookFromFile(args[0])
    }
    Application(book).menu()

}

object PhoneBookFile {
    private var pathString: String = ""
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()!!

    private val phoneBookAdapter = moshi.adapter(PhoneBook::class.java)!!

    fun readPhoneBookFromFile(ps: String): PhoneBook {
        pathString = ps
        val file = File(pathString)
        return phoneBookAdapter.fromJson(file.readBytes().toString()) ?: PhoneBook()
    }

    fun writePhoneBookToFile(book: PhoneBook) {
        if (pathString.isEmpty()) return
        val file = File(pathString)
        file.writeBytes(phoneBookAdapter.toJson(book).toByteArray())
    }

}
