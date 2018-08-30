package triangle

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

object TriangleTest : Spek({

    describe("事前条件") {

        context("無効な三角形") {

            it("3辺のうちどれか1つでも0以下の値を与えたら例外が発生する") {
                assertFailsWith<IllegalArgumentException> { Triangle(0, 1, 2) }
                assertFailsWith<IllegalArgumentException> { Triangle(1, -1, 2) }
                assertFailsWith<IllegalArgumentException> { Triangle(1, 2, -3) }
            }

            it("x + y が z 以下の場合に例外が発生する") {
                assertFailsWith<IllegalArgumentException> { Triangle(1, 2, 5) }
            }

            it("y + z が x 以下の場合に例外が発生する") {
                assertFailsWith<IllegalArgumentException> { Triangle(3, 2, 1) }
            }

            it("z + x が y 以下の場合に例外が発生する") {
                assertFailsWith<IllegalArgumentException> { Triangle(2, 4, 2) }
            }
        }
    }

    describe("三角形の種類を判定") {

        context("3辺がすべて等しい") {

            it("verifyは正三角形を返す") {
                assertEquals(Triangle.Type.EQUILATERAL, Triangle(1, 1, 1).verify())
            }
        }

        context("2辺が等しい") {

            it("verifyは二等辺三角形を返す") {
                assertEquals(Triangle.Type.ISOSCELES, Triangle(2, 2, 3).verify())
                assertEquals(Triangle.Type.ISOSCELES, Triangle(2, 4, 4).verify())
                assertEquals(Triangle.Type.ISOSCELES, Triangle(5, 1, 5).verify())
            }
        }

        context("3辺がすべて等しくない") {

            it("verifyは通常の三角形を返す") {
                assertEquals(Triangle.Type.NORMAL, Triangle(3, 4, 5).verify())
            }
        }
    }
})
