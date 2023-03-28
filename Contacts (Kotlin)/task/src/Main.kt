package contacts

fun String.answer(): Any {
    println(this)
    return readln()
}

object Application {
    fun dialog() {
        val name = "Enter the name of the person:".answer() as String
        val surName = "Enter the surname of the person:".answer() as String
        val number = "Enter the number:".answer() as String
        val record = PhoneBook.Record()
        record.firstName = name
        record.surName = surName
        record.number = number
        PhoneBook(record)
    }
}

fun main() {
    Application.dialog()
}