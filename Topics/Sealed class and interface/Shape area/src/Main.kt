@SuppressWarnings("MagicNumber")
fun calculateArea(shape: Shape): Double {
    return when (shape) {
        is Shape.Square -> shape.side * shape.side
        is Shape.Rectangle -> shape.height * shape.width
        is Shape.Circle -> Math.PI * shape.radius * shape.radius
        is Shape.Triangle -> shape.base * shape.height / 2.0
        is Shape.Pentagon -> 0.25 * kotlin.math.sqrt(5.0 * (5.0 + 2 * kotlin.math.sqrt(5.0))) * shape.side * shape.side
    }
}

sealed class Shape {
    data class Rectangle(val width: Double, val height: Double) : Shape()
    data class Square(val side: Double) : Shape()
    data class Circle(val radius: Double) : Shape()
    data class Triangle(val base: Double, val height: Double) : Shape()
    data class Pentagon(val side: Double) : Shape()
}
