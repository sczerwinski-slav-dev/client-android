package dev.slav.client.android.navigation

import kotlinx.serialization.Serializable

/**
 * Navigation destination defined in main application module.
 */
sealed interface MainNavDestination {

    /**
     * Navigation destination for home screen.
     */
    @Serializable
    data object Home : MainNavDestination
}
