package dev.slav.client.android.settings.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.content.res.Configuration.UI_MODE_TYPE_NORMAL
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import dev.slav.client.android.common.ui.components.text.BodyLarge
import dev.slav.client.android.common.ui.components.text.Disabled
import dev.slav.client.android.common.ui.preview.PreviewWrapper

/**
 * Setting label text.
 *
 * @param text Text of the label.
 * @param modifier Modifier to be applied to this text.
 * @param enabled Enabled state of the label.
 */
@Composable
fun SettingLabel(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    if (enabled) {
        SettingLabelText(
            text = text,
            modifier = modifier
        )
    } else {
        Disabled {
            SettingLabelText(
                text = text,
                modifier = modifier
            )
        }
    }
}

@Composable
private fun SettingLabelText(text: String, modifier: Modifier) {
    BodyLarge(
        text = text,
        modifier = modifier,
        overflow = TextOverflow.Ellipsis,
        maxLines = 1
    )
}

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO or UI_MODE_TYPE_NORMAL
)
@Composable
fun SettingLabelPreviewDay() = SettingLabelPreview()

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES or UI_MODE_TYPE_NORMAL
)
@Composable
fun SettingLabelPreviewNight() = SettingLabelPreview()

@Composable
private fun SettingLabelPreview() {
    PreviewWrapper {
        SettingLabel(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
            modifier = Modifier.fillMaxWidth()
        )
    }
}
