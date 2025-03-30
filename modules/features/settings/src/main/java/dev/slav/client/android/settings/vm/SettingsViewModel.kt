package dev.slav.client.android.settings.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.slav.client.android.settings.domain.Settings
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * View model for settings screen.
 */
@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val settings: Settings
) : ViewModel() {

    /**
     * System theme indicator.
     *
     * If `true`, system colors should be used
     * instead of application theme colors.
     */
    val systemTheme: Flow<Boolean>
        get() = settings.systemTheme

    /**
     * Dark mode indicator.
     *
     * If `null`, system dark mode setting should be used.
     */
    val darkMode: Flow<Boolean?>
        get() = settings.darkMode

    /**
     * Set new system theme setting.
     *
     * @param newSystemTheme New system theme setting.
     */
    fun setSystemTheme(newSystemTheme: Boolean) {
        viewModelScope.launch {
            settings.setSystemTheme(newSystemTheme)
        }
    }

    /**
     * Set new dark mode setting.
     *
     * @param newDarkMode New dark mode setting.
     */
    fun setDarkMode(newDarkMode: Boolean?) {
        viewModelScope.launch {
            settings.setDarkMode(newDarkMode)
        }
    }
}
