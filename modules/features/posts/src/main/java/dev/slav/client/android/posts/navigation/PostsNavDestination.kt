package dev.slav.client.android.posts.navigation

import kotlinx.serialization.Serializable

/**
 * Navigation destination related to posts.
 */
sealed interface PostsNavDestination {

    /**
     * Navigation destination for list of posts.
     */
    @Serializable
    data object PostsList : PostsNavDestination
}
