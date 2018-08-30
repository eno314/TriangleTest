package triangle

class Triangle(private val x: Int, private val y: Int, private val z: Int) {
    enum class Type {
        EQUILATERAL,
        INVALID
    }

    fun verify(): Type? {
        if (x <= 0 || y <= 0 || z <= 0) {
            return Type.INVALID
        }
        if (x + y <= z) {
            return Type.INVALID
        }
        if (y + z <= x) {
            return Type.INVALID
        }
        if (z + x <= y) {
            return Type.INVALID
        }
        if (x == y && y == z && z == x) {
            return Type.EQUILATERAL
        }
        return null
    }

}
