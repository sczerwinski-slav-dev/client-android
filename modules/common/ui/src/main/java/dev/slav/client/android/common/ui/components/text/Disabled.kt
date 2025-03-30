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
 * Disabled element wrapper.
 *
 * Styles elements inside as disabled.
 *
 * @param content Text to be styled as disabled.
 */
@Composable
fun Disabled(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        value = LocalContentColor.provides(
            LocalContentColor.current.copy(alpha = DisabledAlpha)
        ),
        content = content
    )
}

private const val DisabledAlpha = 0.3f

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO or UI_MODE_TYPE_NORMAL
)
@Composable
fun DisabledPreviewDay() = DisabledPreview()

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES or UI_MODE_TYPE_NORMAL
)
@Composable
fun DisabledPreviewNight() = DisabledPreview()

@Composable
private fun DisabledPreview() {
    PreviewWrapper {
        Disabled {
            BodyLarge("Lorem ipsum dolor sit amet,\nconsectetur adipiscing elit")
        }
    }
}
