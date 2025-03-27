package dev.slav.client.android.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.content.res.Configuration.UI_MODE_TYPE_NORMAL
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import dev.slav.client.android.common.ui.components.text.LabelSmall
import dev.slav.client.android.common.ui.preview.PreviewWrapper
import dev.slav.client.android.navigation.HomeNavItem

/**
 * Home screen bottom navigation bar.
 *
 * @param currentNavItem Selected navigation bar item.
 * @param onNavItemClick Callback to be executed when a navigation item is clicked.
 */
@Composable
fun HomeScreenNavBar(
    currentNavItem: HomeNavItem,
    onNavItemClick: (navItem: HomeNavItem) -> Unit
) {
    NavigationBar(modifier = Modifier.fillMaxWidth()) {
        for (navItem in HomeNavItem.entries) {
            val label = stringResource(id = navItem.labelRes)

            NavigationBarItem(
                selected = navItem == currentNavItem,
                onClick = { onNavItemClick(navItem) },
                icon = { Icon(imageVector = navItem.icon, contentDescription = label) },
                modifier = Modifier.navigationBarsPadding(),
                label = { LabelSmall(text = label) }
            )
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO or UI_MODE_TYPE_NORMAL
)
@Composable
fun HomeScreenNavBarPreviewDay() = HomeScreenNavBarPreview()

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES or UI_MODE_TYPE_NORMAL
)
@Composable
fun HomeScreenNavBarPreviewNight() = HomeScreenNavBarPreview()

@Composable
private fun HomeScreenNavBarPreview() {
    PreviewWrapper {
        HomeScreenNavBar(
            currentNavItem = HomeNavItem.default,
            onNavItemClick = {}
        )
    }
}
