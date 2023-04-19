data class Vector2(var x: Int, var y: Int)

interface PhysicalBody2D {
    val affectedByGravity: Boolean
        get() = true
    val simulated: Boolean
        get() = true

    val mass: Double
    val gravityStrength: Double

    val velocity: Vector2

    fun simulate()
    fun stopSimulation()
    fun setVelocityToZero()
}

/*
    Physical body with a mass of 0.25,
    Velocity of 0,
    And no additional gravity strength
*/
@SuppressWarnings("MagicNumber")
class Stone : PhysicalBody2D {
    override val mass: Double = 0.25

    override val gravityStrength: Double = 1.0

    override val velocity: Vector2 = Vector2(0, 0)

    override fun simulate() {
        // Some code, which you don't need to implement
    }

    override fun stopSimulation() {
        // Some code, which you don't need to implement
    }

    override fun setVelocityToZero() {
        velocity.x = 0
        velocity.y = 0
    }
}