package contacts

class PhoneBook(a: Record) {
    private val phoneBook = mutableListOf<Record>()

    init {
        phoneBook.add(a)
        println("A Phone Book with a single record created!")
    }


    class Record {
        var firstName = ""
        var surName = ""
        var number = ""

        init {

            println("A record created!")

        }
    }


}