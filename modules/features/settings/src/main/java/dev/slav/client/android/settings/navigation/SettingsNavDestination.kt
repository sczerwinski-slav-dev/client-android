package dev.slav.client.android.settings.navigation

import kotlinx.serialization.Serializable

/**
 * Navigation destination related to settings.
 */
sealed interface SettingsNavDestination {

    /**
     * Navigation destination for settings screen.
     */
    @Serializable
    data object Settings : SettingsNavDestination
}
