package dev.slav.client.android

import androidx.test.platform.app.InstrumentationRegistry
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@DisplayName(value = "Example instrumented test")
class ExampleInstrumentedTest {
    @Test
    @DisplayName(
        value = "GIVEN test starts, " +
                "WHEN get application context, " +
                "THEN package name should equal to 'dev.slav.client.android'"
    )
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertThat(appContext.packageName).isEqualTo("dev.slav.client.android")
    }
}
