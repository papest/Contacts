data class Color(val code: Int) {
    override fun toString() = "$code"
}

interface Listed {
    val index: String
}

interface Tabulated : Listed {
    val row: Int
    val column: Int
    val dataType: String
    val isEmpty: Boolean

    override val index: String
}

interface Colored {
    val color: Color
}

interface TableCell : Tabulated, Colored {
    val info: String
        get() = "$column, $row; Color: $color"
}

class Cell(
    override val row: Int,
    override val column: Int,
    override val dataType: String,
    override val isEmpty: Boolean,
    override val color: Color
) : TableCell {
    override val index: String
        get() = TODO("Not yet implemented")
}

fun main() {

// Initialize colors:
    val red = Color(1)
    val blue = Color(2)
    val green = Color(3)

// Create colored cells
    val redCell = Cell(5, 2, "string", false, red)
    val blueCell = Cell(2, 6, "string", false, blue)
    val greenCell = Cell(1, 4, "string", false, green)
    println(redCell.info)
    println(blueCell.info)
    println(greenCell.info)
}