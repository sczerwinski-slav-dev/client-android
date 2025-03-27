package dev.slav.client.android.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink
import dev.slav.client.android.R
import dev.slav.client.android.ui.HomeScreen

/**
 * Main navigation host of the application.
 */
@Composable
fun MainNavHost() {
    val mainNavController = rememberNavController()
    val navBaseUrl = stringResource(id = R.string.nav_base_url)

    NavHost(
        navController = mainNavController,
        startDestination = MainNavDestination.Home
    ) {
        composable<MainNavDestination.Home>(
            deepLinks = listOf(
                navDeepLink<MainNavDestination.Home>(basePath = "$navBaseUrl/")
            )
        ) {
            HomeScreen(mainNavController)
        }
    }
}
