package dev.slav.client.android.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink
import androidx.navigation.toRoute
import dev.slav.client.android.R
import dev.slav.client.android.common.ui.layouts.Placeholder
import dev.slav.client.android.posts.navigation.PostsNavDestination
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

        composable<PostsNavDestination.Post>(
            deepLinks = listOf(
                navDeepLink<PostsNavDestination.Post>(basePath = "$navBaseUrl/posts")
            )
        ) { backStackEntry ->
            val destination = backStackEntry.toRoute<PostsNavDestination.Post>()
            Placeholder(
                text = "Post: ${destination.postId}",
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}
