package triangle

class Triangle(private val x: Int, private val y: Int, private val z: Int) {

    enum class Type {
        EQUILATERAL,
        ISOSCELES,
        NORMAL
    }

    init {
        if (x <= 0 || y <= 0 || z <= 0) {
            throw IllegalArgumentException("invalid triangle")
        }
        if (x + y <= z) {
            throw IllegalArgumentException("invalid triangle")
        }
        if (y + z <= x) {
            throw IllegalArgumentException("invalid triangle")
        }
        if (z + x <= y) {
            throw IllegalArgumentException("invalid triangle")
        }
    }

    fun verify(): Type? {
        if (x == y && y == z && z == x) {
            return Type.EQUILATERAL
        }
        if (x == y) {
            return Type.ISOSCELES
        }
        if (y == z) {
            return Type.ISOSCELES
        }
        if (z == x) {
            return Type.ISOSCELES
        }
        return Type.NORMAL
    }

}
