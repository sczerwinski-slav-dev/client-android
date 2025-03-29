package dev.slav.client.android.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector
import dev.slav.client.android.R
import dev.slav.client.android.posts.navigation.PostsNavDestination

/**
 * Home screen bottom navigation bar item.
 *
 * @property destination Navigation destination.
 * @property labelRes String resource ID for navigation item label.
 * @property icon Navigation item icon.
 */
enum class HomeNavItem(
    val destination: Any,
    @StringRes val labelRes: Int,
    val icon: ImageVector
) {

    /**
     * Home screen item.
     */
    Home(
        destination = PostsNavDestination.PostsList,
        labelRes = R.string.home_nav_item_home,
        icon = Icons.Outlined.Home
    );

    companion object {

        /**
         * Default navigation bar item.
         */
        val default = Home
    }
}
