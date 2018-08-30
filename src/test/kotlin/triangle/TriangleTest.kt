package triangle

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature
import kotlin.test.assertEquals

object TriangleTest : Spek({

    lateinit var triangle: Triangle

    Feature("三角形の種類を判定する") {
        Scenario("三角形を作ることができるかの判定") {
            Given("3辺のうちどれか1つでも0以下の値を与える") {
                triangle = Triangle(0, 1, 2)
            }
        }

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
