package dev.slav.client.android.settings.domain.impl

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import dev.slav.client.android.settings.domain.Settings
import it.czerwinski.android.hilt.annotations.Bound
import it.czerwinski.android.hilt.getValue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

/**
 * Application settings stored in shared preferences.
 *
 * @see Settings
 */
@Bound
@Singleton
class PreferencesSettings @Inject constructor(
    @ApplicationContext private val contextProvider: Provider<Context>
) : Settings {

    private val context: Context by contextProvider

    private val sharedPreferences: SharedPreferences
        get() = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)

    private val _systemTheme = MutableStateFlow(false)
    private val _darkMode = MutableStateFlow<Boolean?>(null)

    override val systemTheme: Flow<Boolean>
        get() = _systemTheme

    override val darkMode: Flow<Boolean?>
        get() = _darkMode

    init {
        val systemTheme = sharedPreferences.getBoolean(KEY_SYSTEM_THEME, false)

        val overrideDarkMode = sharedPreferences.contains(KEY_DARK_MODE)
        val darkMode = if (overrideDarkMode) {
            sharedPreferences.getBoolean(KEY_DARK_MODE, false)
        } else {
            null
        }

        CoroutineScope(Dispatchers.Default).launch {
            _systemTheme.emit(systemTheme)
            _darkMode.emit(darkMode)
        }
    }

    override suspend fun setSystemTheme(newSystemTheme: Boolean) {
        sharedPreferences.edit(commit = true) {
            putBoolean(KEY_SYSTEM_THEME, newSystemTheme)
        }
        _systemTheme.emit(newSystemTheme)
    }

    override suspend fun setDarkMode(newDarkMode: Boolean?) {
        sharedPreferences.edit(commit = true) {
            if (newDarkMode == null) {
                remove(KEY_DARK_MODE)
            } else {
                putBoolean(KEY_DARK_MODE, newDarkMode)
            }
        }
        _darkMode.emit(newDarkMode)
    }

    companion object {
        private const val PREFERENCES_NAME = "settings"
        private const val KEY_SYSTEM_THEME = "system_theme"
        private const val KEY_DARK_MODE = "dark_mode"
    }
}
