package triangle

class Triangle(private val x: Int, private val y: Int, private val z: Int) {

    enum class Type {
        /**
         * 正三角形
         */
        EQUILATERAL,
        /**
         * 二等辺三角形
         */
        ISOSCELES,
        /**
         * 通常三角形（不等辺三角形）
         */
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
        if (x == y || y == z || z == x) {
            return Type.ISOSCELES
        }
        return Type.NORMAL
    }

}
