package contacts

import kotlinx.datetime.*
import kotlinx.datetime.Clock.System.now

const val NO_DATA = "[no data]"

class PhoneBook {
    private val phoneBook = mutableListOf<Record>()

    open class Record {
        open val editFields: String = ""
        private val regex =
            "\\+?((\\([\\da-zA-Z]+\\))|([\\da-zA-Z]+))(([ -])((\\([\\da-zA-Z]{2,}\\))|([\\da-zA-Z]{2,})))?(([ -])[\\da-zA-Z]{2,})*".toRegex()
        var number = ""
            set(value) {
                field = if ("\\(".toRegex().findAll(value)
                        .count() < 2 && checkNumber(value)
                ) value else {
                    println("Wrong number format!")
                    ""
                }
            }
        private val createdTime = now()
        var updatedTime: Instant = createdTime

        private fun checkNumber(number: String): Boolean {
            return regex.matches(number)
        }

        private fun hasNumber(): Boolean = number.isNotEmpty()

        open fun add() {
            number = "Enter the number:".answer()
        }

        open fun setField(fieldName: String, value: String) {
            updatedTime = now()
        }

        open fun info() = """Number: ${if (hasNumber()) number else "[no number]"} 
Time created: $createdTime 
Time last edit: $updatedTime"""
    }

    class PersonRecord : Record() {
        override val editFields = "name, surname, birth, gender, number"
        private var firstName: String = ""
        private var surName: String = ""
        private var gender: String? = null
            set(value) {
                field = if (value == "F" || value == "M") {
                    value
                } else {
                    println("Bad gender!")
                    null
                }
            }

        private var birthDay: String? = null
            set(value) {
                if (value == null) {
                    field = value
                } else {
                    try {
                        field = LocalDate.parse(value).toString()
                    } catch (e: Exception) {
                        field = null
                        println("Bad birth date!")
                    }
                }
            }

        override fun add() {
            firstName = "Enter the name:".answer()
            surName = "Enter the surname:".answer()
            birthDay = "Enter the birth date:".answer()
            gender = "Enter the gender (M, F):".answer()
            super.add()
        }

        override fun setField(fieldName: String, value: String) {
            when (fieldName) {
                "name" -> firstName = value
                "surname" -> surName = value
                "number" -> number = value
                "gender" -> gender = value
                "birth" -> birthDay = value
            }
            super.setField(fieldName, value)
        }

        override fun info(): String = """Name: $firstName
Surname: $surName
Birth date: ${birthDay ?: NO_DATA}
Gender: ${gender ?: NO_DATA}
""" + super.info()

        override fun toString(): String = "$firstName $surName"
    }

    class OrganizationRecord : Record() {
        override val editFields = "address, number"
        private var organizationName = ""
        private var address = ""

        override fun add() {
            organizationName = "Enter the organization name:".answer()
            address = "Enter the address:".answer()
            super.add()
        }

        override fun setField(fieldName: String, value: String) {
            when (fieldName) {
                "address" -> address = value
                "number" -> number = value
            }
            super.setField(fieldName, value)
        }

        override fun info(): String = """Organization name: $organizationName
Address: $address
""" + super.info()

        override fun toString(): String = organizationName

    }

    fun add() {
        val record: Record = if ("Enter the type (person, organization):".answer() == "person") PersonRecord()
        else OrganizationRecord()
        record.add()
        record.updatedTime = now()
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
        val fieldName = "Select a field (${phoneBook[ind].editFields}):".answer()
        val value = "Enter $fieldName:".answer()
        phoneBook[ind].setField(fieldName, value)
        println("The record updated!")

    }

    fun info() {
        if (phoneBook.isEmpty()) {
            println("No records!")
            return
        }
        println(this)
        val ind = "Enter index to show info:".answer().toInt() - 1
        println(phoneBook[ind].info())
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

    override fun toString(): String = phoneBook.indices.joinToString("\n") { "${it + 1}. ${phoneBook[it]}" }

}