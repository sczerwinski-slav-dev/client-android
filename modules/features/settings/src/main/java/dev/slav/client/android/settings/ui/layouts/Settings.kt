package dev.slav.client.android.settings.ui.layouts

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.content.res.Configuration.UI_MODE_TYPE_NORMAL
import android.os.Build
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import dev.slav.client.android.common.ui.layouts.SpacingIndent
import dev.slav.client.android.common.ui.preview.PreviewWrapper
import dev.slav.client.android.settings.R
import dev.slav.client.android.settings.ui.components.SwitchSetting

/**
 * Application settings.
 *
 * @param systemTheme System theme usage indicator.
 * @param onSystemThemeChange Callback executed when system theme setting is changed.
 * @param darkMode Dark mode indicator. When `null` system setting is used.
 * @param onDarkModeChange Callback executed when dark mode setting is changed.
 * @param modifier Modifier to be applied to this node.
 */
@Composable
fun Settings(
    systemTheme: Boolean,
    onSystemThemeChange: (Boolean) -> Unit,
    darkMode: Boolean?,
    onDarkModeChange: (Boolean?) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier then Modifier
            .verticalScroll(state = rememberScrollState())
    ) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            SwitchSetting(
                text = stringResource(id = R.string.settings_system_theme),
                checked = systemTheme,
                onCheckedChange = onSystemThemeChange,
                modifier = Modifier.fillMaxWidth()
            )
            HorizontalDivider()
        }
        SwitchSetting(
            text = stringResource(id = R.string.settings_override_system_dark_mode),
            checked = darkMode != null,
            onCheckedChange = { newValue ->
                onDarkModeChange(if (newValue) darkMode == true else null)
            },
            modifier = Modifier.fillMaxWidth()
        )
        Column(modifier = Modifier.padding(start = SpacingIndent)) {
            HorizontalDivider()
            SwitchSetting(
                text = stringResource(id = R.string.settings_dark_mode),
                checked = darkMode == true,
                onCheckedChange = onDarkModeChange,
                modifier = Modifier.fillMaxWidth(),
                enabled = darkMode != null
            )
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO or UI_MODE_TYPE_NORMAL
)
@Composable
fun SettingsPreviewDay() = SettingsPreview()

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES or UI_MODE_TYPE_NORMAL
)
@Composable
fun SettingsPreviewNight() = SettingsPreview()

@Composable
private fun SettingsPreview() {
    PreviewWrapper {
        Settings(
            systemTheme = false,
            onSystemThemeChange = {},
            darkMode = true,
            onDarkModeChange = {},
            modifier = Modifier.fillMaxSize()
        )
    }
}
