package triangle

import org.assertj.core.api.Assertions
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature

object TriangleTest : Spek({

    lateinit var triangle: Triangle

    Feature("正三角形の種類を判定する") {
        Scenario("正三角形") {
            Given("３辺にすべて等しい引数を与える") {
                triangle = Triangle(1, 1, 1)
            }
            Then("verifyは正三角形を返す") {
                Assertions.assertThat(triangle.verify()).isEqualTo(Triangle.Type.EQUILATERAL)
            }
        }
    }
})
