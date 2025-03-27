package dev.slav.client.android.common.ui.components.text

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.content.res.Configuration.UI_MODE_TYPE_NORMAL
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.tooling.preview.Preview
import dev.slav.client.android.common.ui.preview.PreviewWrapper

/**
 * Secondary element wrapper.
 *
 * Styles elements inside as secondary.
 *
 * @param content Text to be styled as secondary.
 */
@Composable
fun Secondary(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        value = LocalContentColor.provides(
            LocalContentColor.current.copy(alpha = SecondaryAlpha)
        ),
        content = content
    )
}

private const val SecondaryAlpha = 0.6f

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO or UI_MODE_TYPE_NORMAL
)
@Composable
fun SecondaryPreviewDay() = SecondaryPreview()

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES or UI_MODE_TYPE_NORMAL
)
@Composable
fun SecondaryPreviewNight() = SecondaryPreview()

@Composable
private fun SecondaryPreview() {
    PreviewWrapper {
        Secondary {
            BodyLarge("Lorem ipsum dolor sit amet,\nconsectetur adipiscing elit")
        }
    }
}
