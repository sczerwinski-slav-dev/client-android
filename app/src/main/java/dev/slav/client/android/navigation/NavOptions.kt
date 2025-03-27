package dev.slav.client.android.navigation

import androidx.navigation.NavOptions

/**
 * Navigation options for home screen bottom navigation.
 */
val homeNavOptions = NavOptions.Builder()
    .setPopUpTo(
        HomeNavItem.default.destination,
        inclusive = false,
        saveState = true
    )
    .setLaunchSingleTop(true)
    .build()
