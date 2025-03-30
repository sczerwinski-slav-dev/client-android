package dev.slav.client.android.settings.ui

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.content.res.Configuration.UI_MODE_TYPE_NORMAL
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import dev.slav.client.android.common.ui.preview.PreviewWrapper
import dev.slav.client.android.settings.domain.Settings
import dev.slav.client.android.settings.ui.layouts.Settings
import dev.slav.client.android.settings.vm.SettingsViewModel

/**
 * Application settings screen.
 *
 * @param viewModel View model.
 */
@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel = hiltViewModel()
) {
    val systemTheme by viewModel.systemTheme.collectAsState(initial = Settings.DEFAULT_SYSTEM_THEME)
    val darkMode by viewModel.darkMode.collectAsState(initial = Settings.DEFAULT_DARK_MODE)

    SettingsScreen(
        systemTheme = systemTheme,
        onSystemThemeChange = viewModel::setSystemTheme,
        darkMode = darkMode,
        onDarkModeChange = viewModel::setDarkMode
    )
}

@Composable
fun SettingsScreen(
    systemTheme: Boolean,
    onSystemThemeChange: (Boolean) -> Unit,
    darkMode: Boolean?,
    onDarkModeChange: (Boolean?) -> Unit
) {
    Settings(
        systemTheme = systemTheme,
        onSystemThemeChange = onSystemThemeChange,
        darkMode = darkMode,
        onDarkModeChange = onDarkModeChange,
        modifier = Modifier.fillMaxSize()
    )
}

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO or UI_MODE_TYPE_NORMAL
)
@Composable
fun SettingsScreenPreviewDay() = SettingsScreenPreview()

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES or UI_MODE_TYPE_NORMAL
)
@Composable
fun SettingsScreenPreviewNight() = SettingsScreenPreview()

@Composable
private fun SettingsScreenPreview() {
    PreviewWrapper {
        SettingsScreen(
            systemTheme = true,
            onSystemThemeChange = {},
            darkMode = null,
            onDarkModeChange = {}
        )
    }
}
