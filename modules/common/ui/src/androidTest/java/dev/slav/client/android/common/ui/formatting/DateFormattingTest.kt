package dev.slav.client.android.common.ui.formatting

import androidx.compose.material3.Text
import androidx.compose.ui.test.DeviceConfigurationOverride
import androidx.compose.ui.test.Locales
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.text.intl.LocaleList
import de.mannodermaus.junit5.compose.AndroidComposeExtension
import de.mannodermaus.junit5.compose.ComposeExtension
import dev.slav.client.android.common.ui.theme.SlavDevTheme
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.time.LocalDate

@DisplayName("Instrumented tests for date formatting")
@ExtendWith(AndroidComposeExtension::class)
class DateFormattingTest {

    @Test
    @DisplayName(
        "GIVEN I am in UK, " +
            "WHEN I format a date using long date format, " +
            "THEN I should a British date"
    )
    fun shouldFormatLongDateUK(extension: ComposeExtension) = extension.use {
        val date = LocalDate.of(2025, 1, 15)

        setContent {
            DeviceConfigurationOverride(
                DeviceConfigurationOverride.Locales(LocaleList("en-rUK"))
            ) {
                SlavDevTheme {
                    Text(text = date.formatLongDate())
                }
            }
        }

        onNodeWithText("15 January 2025")
            .assertIsDisplayed()
    }

    @Test
    @DisplayName(
        "GIVEN I am in US, " +
            "WHEN I format a date using long date format, " +
            "THEN I should an American date"
    )
    fun shouldFormatLongDateUS(extension: ComposeExtension) = extension.use {
        val date = LocalDate.of(2025, 1, 15)

        setContent {
            DeviceConfigurationOverride(
                DeviceConfigurationOverride.Locales(LocaleList("en-rUS"))
            ) {
                SlavDevTheme {
                    Text(text = date.formatLongDate())
                }
            }
        }

        onNodeWithText("15 January 2025")
            .assertIsDisplayed()
    }
}
