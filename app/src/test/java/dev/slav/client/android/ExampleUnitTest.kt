package dev.slav.client.android

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@DisplayName(value = "Example unit test")
class ExampleUnitTest {

    @Test
    @DisplayName(
        value = "GIVEN two numbers: 2 and 2, " +
                "WHEN add, " +
                "THEN result should be equal to 4"
    )
    fun addition_isCorrect() {
        assertThat(2 + 2).isEqualTo(4)
    }
}
