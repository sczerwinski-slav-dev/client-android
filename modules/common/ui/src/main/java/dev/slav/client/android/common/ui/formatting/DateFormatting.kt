package dev.slav.client.android.common.ui.formatting

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import dev.slav.client.android.common.ui.R
import java.time.LocalDate
import java.time.format.DateTimeFormatter

private lateinit var longDateFormatter: DateTimeFormatter

/**
 * Format this date using long date format.
 *
 * @return Date formatted using long date format.
 */
@Composable
fun LocalDate.formatLongDate(): String {
    if (!::longDateFormatter.isInitialized) {
        val pattern = stringResource(id = R.string.date_format_long)
        longDateFormatter = DateTimeFormatter.ofPattern(pattern)
    }
    return format(longDateFormatter)
}
