package triangle

class Triangle(private val x: Int, private val y: Int, private val z: Int) {
    enum class Type {
        EQUILATERAL
    }

    fun verify(): Type? {
        if (x == y && y == z && z == x) {
            return Type.EQUILATERAL
        }
        return null
    }

}
