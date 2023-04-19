interface Shape {
    val angles: Int
    val scale: Double
        get() = 1.0

    fun draw()
}