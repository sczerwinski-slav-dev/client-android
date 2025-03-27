package dev.slav.client.android.ui

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.content.res.Configuration.UI_MODE_TYPE_NORMAL
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import dev.slav.client.android.common.ui.preview.PreviewWrapper
import dev.slav.client.android.navigation.HomeNavHost
import dev.slav.client.android.navigation.HomeNavItem
import dev.slav.client.android.navigation.homeNavOptions
import dev.slav.client.android.ui.components.HomeScreenAppBar
import dev.slav.client.android.ui.components.HomeScreenNavBar

/**
 * Home screen.
 *
 * @param navController Navigation controller used to navigate outside of home screen.
 */
@Composable
fun HomeScreen(
    navController: NavController
) {
    HomeScreenContent(parentNavController = navController)
}

@Composable
private fun HomeScreenContent(
    parentNavController: NavController
) {
    val homeNavController = rememberNavController()
    var currentNavItem by remember { mutableStateOf(HomeNavItem.default) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { HomeScreenAppBar() },
        bottomBar = {
            HomeScreenNavBar(
                currentNavItem = currentNavItem,
                onNavItemClick = { navItem ->
                    currentNavItem = navItem
                    homeNavController.navigate(
                        route = navItem.destination,
                        navOptions = homeNavOptions
                    )
                }
            )
        }
    ) { contentPadding ->
        if (!LocalInspectionMode.current) {
            HomeNavHost(
                homeNavController = homeNavController,
                parentNavController = parentNavController,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(contentPadding)
            )
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO or UI_MODE_TYPE_NORMAL
)
@Composable
fun HomeScreenContentPreviewDay() = HomeScreenContentPreview()

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES or UI_MODE_TYPE_NORMAL
)
@Composable
fun HomeScreenContentPreviewNight() = HomeScreenContentPreview()

@Composable
private fun HomeScreenContentPreview() {
    PreviewWrapper {
        HomeScreenContent(
            parentNavController = rememberNavController()
        )
    }
}
