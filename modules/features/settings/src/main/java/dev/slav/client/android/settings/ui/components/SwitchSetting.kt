package dev.slav.client.android.settings.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.content.res.Configuration.UI_MODE_TYPE_NORMAL
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import dev.slav.client.android.common.ui.layouts.SpacingLarge
import dev.slav.client.android.common.ui.preview.PreviewWrapper

/**
 * Boolean setting controlled using a switch.
 *
 * @param text Text displayed for the setting.
 * @param checked Current value of the setting.
 * @param onCheckedChange Callback executed when this setting changes.
 * @param modifier Modifier to be applied to this node.
 */
@Composable
fun SwitchSetting(
    text: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Row(
        modifier = modifier then Modifier.padding(SpacingLarge),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        SettingLabel(
            text = text,
            modifier = Modifier.weight(1f),
            enabled = enabled
        )
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange,
            modifier = Modifier.testTag("settings:$text:switch"),
            enabled = enabled
        )
    }
}

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO or UI_MODE_TYPE_NORMAL
)
@Composable
fun SwitchSettingPreviewDay() = SwitchSettingPreview()

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES or UI_MODE_TYPE_NORMAL
)
@Composable
fun SwitchSettingPreviewNight() = SwitchSettingPreview()

@Composable
private fun SwitchSettingPreview() {
    PreviewWrapper {
        SwitchSetting(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
            checked = true,
            onCheckedChange = {},
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO or UI_MODE_TYPE_NORMAL
)
@Composable
fun SwitchSettingPreviewDisabledDay() = SwitchSettingPreviewDisabled()

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES or UI_MODE_TYPE_NORMAL
)
@Composable
fun SwitchSettingPreviewDisabledNight() = SwitchSettingPreviewDisabled()

@Composable
private fun SwitchSettingPreviewDisabled() {
    PreviewWrapper {
        SwitchSetting(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
            checked = false,
            onCheckedChange = {},
            modifier = Modifier.fillMaxWidth(),
            enabled = false
        )
    }
}
