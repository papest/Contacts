package contacts

class PhoneBook {
    private val phoneBook = mutableListOf<Record>()

    class Record {
        private val regex =
            "\\+?((\\([\\da-zA-Z]+\\))|([\\da-zA-Z]+))(([ ]|[-])((\\([\\da-zA-Z]{2,}\\))|([\\da-zA-Z]{2,})))?(([ ]|[-])[\\da-zA-Z]{2,})*".toRegex()
        private var firstName = ""
        private var surName = ""
        private var number = ""
            set(value) {
                field = if ("\\(".toRegex().findAll(value).count() < 2 && checkNumber(value)) value else {
                    println("Wrong number format!")
                    ""
                }
            }

        fun setField(fieldName: String, value: String) {
            when (fieldName) {
                "name" -> firstName = value
                "surname" -> surName = value
                "number" -> number = value
            }
        }

        constructor(firstName: String, surname: String, number: String) {
            this.firstName = firstName
            this.surName = surname
            this.number = number
        }

        private fun checkNumber(number: String): Boolean {
            return regex.matches(number)
        }

        private fun hasNumber(): Boolean = number.isNotEmpty()
        override fun toString() = "$firstName $surName, ${if (hasNumber()) number else "[no number]"}"
    }

    fun add() {
        val firstName = "Enter the name:".answer()
        val surname = "Enter the surname:".answer()
        val number = "Enter the number:".answer()
        val record = Record(firstName, surname, number)
        phoneBook.add(record)
        println("The record added.")
    }

    fun edit() {
        if (phoneBook.isEmpty()) {
            println("No records to edit!")
            return
        }
        println(this)
        val ind = "Select a record:".answer().toInt() - 1
        val fieldName = "Select a field (name, surname, number):".answer()
        val value = "Enter $fieldName:".answer()
        phoneBook[ind].setField(fieldName, value)
        println("The record updated!")

    }

    fun count() {
        println("The Phone Book has ${phoneBook.size} records.")
    }

    fun remove() {
        if (phoneBook.isEmpty()) {
            println("No records to remove!")
            return
        }

        println(this)
        val ind = "Select a record:".answer().toInt() - 1
        phoneBook.removeAt(ind)
        println("The record removed!")
    }

    fun list() = println(this)

    override fun toString(): String = phoneBook.indices.joinToString("\n") { "${it + 1}. ${phoneBook[it]}" }

}