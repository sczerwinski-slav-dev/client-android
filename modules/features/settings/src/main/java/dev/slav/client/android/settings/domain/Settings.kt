package dev.slav.client.android.settings.domain

import kotlinx.coroutines.flow.Flow

/**
 * Application settings.
 */
interface Settings {

    /**
     * System theme indicator.
     *
     * If `true`, system colors should be used
     * instead of application theme colors.
     */
    val systemTheme: Flow<Boolean>

    /**
     * Dark mode indicator.
     *
     * If `null`, system dark mode setting should be used.
     */
    val darkMode: Flow<Boolean?>

    /**
     * Set new system theme setting.
     *
     * @param newSystemTheme New system theme setting.
     */
    suspend fun setSystemTheme(newSystemTheme: Boolean)

    /**
     * Set new dark mode setting.
     *
     * @param newDarkMode New dark mode setting.
     */
    suspend fun setDarkMode(newDarkMode: Boolean?)

    companion object {

        /**
         * Default system theme setting.
         */
        const val DEFAULT_SYSTEM_THEME: Boolean = false

        /**
         * Default dark mode setting.
         */
        val DEFAULT_DARK_MODE: Boolean? = null
    }
}
