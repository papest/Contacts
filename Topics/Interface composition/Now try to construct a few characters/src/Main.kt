interface Level {
    fun getLevel(): Int
}

interface Enemy {
    fun isEnemy(): Boolean
}

interface Class {
    fun getClass(): String
}

object HighLevelled : Level {
    override fun getLevel(): Int = 25
}

object LowLevelled : Level {
    override fun getLevel(): Int = 3
}

object Hostile : Enemy {
    override fun isEnemy(): Boolean = true
}

object Ally : Enemy {
    override fun isEnemy(): Boolean = false
}

object Cleric : Class {
    override fun getClass(): String = "Cleric"
}

object Barbarian : Class {
    override fun getClass(): String = "Barbarian"
}

class HighLevelledAlliedCleric : Class by Cleric, Level by HighLevelled, Enemy by Ally

class LowLevelledHostileBarbarian : Class by Barbarian, Level by LowLevelled, Enemy by Hostile