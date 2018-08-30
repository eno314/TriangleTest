package triangle

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

object TriangleTest : Spek({

    lateinit var triangle: Triangle

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

    Feature("三角形の種類を判定する") {

        Scenario("正三角形") {

            Given("３辺にすべて等しい引数を与える") {
                triangle = Triangle(1, 1, 1)
            }

            Then("verifyは正三角形を返す") {
                assertEquals(Triangle.Type.EQUILATERAL, triangle.verify())
            }
        }
    }
})
