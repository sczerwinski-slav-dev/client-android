package dev.slav.client.android.navigation

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import dev.slav.client.android.R
import dev.slav.client.android.posts.navigation.PostsNavDestination
import dev.slav.client.android.posts.ui.PostsListScreen
import dev.slav.client.android.settings.navigation.SettingsNavDestination
import dev.slav.client.android.settings.ui.SettingsScreen

/**
 * Home screen navigation host.
 *
 * This navigation host is used to navigate between bottom navigation bar items.
 *
 * @param snackbarHostState Snackbar host state used for error notifications.
 * @param homeNavController Home screen navigation controller,
 * used to navigate between bottom navigation bar items on home screen.
 * @param parentNavController Parent navigation controller,
 * used to navigate outside home screen.
 * @param modifier Modifier to be applied to this node.
 */
@Composable
fun HomeNavHost(
    snackbarHostState: SnackbarHostState,
    homeNavController: NavHostController,
    parentNavController: NavController,
    modifier: Modifier = Modifier
) {
    val navBaseUrl = stringResource(id = R.string.nav_base_url)

    NavHost(
        navController = homeNavController,
        startDestination = PostsNavDestination.PostsList,
        modifier = modifier
    ) {
        composable<PostsNavDestination.PostsList>(
            deepLinks = listOf(
                navDeepLink<PostsNavDestination.PostsList>(basePath = "$navBaseUrl/posts")
            )
        ) {
            PostsListScreen(
                snackbarHostState = snackbarHostState,
                navController = parentNavController
            )
        }

        composable<SettingsNavDestination.Settings>(
            deepLinks = listOf(
                navDeepLink<SettingsNavDestination.Settings>(basePath = "$navBaseUrl/settings")
            )
        ) {
            SettingsScreen()
        }
    }
}
