package dev.slav.client.android.posts.navigation

import kotlinx.serialization.Serializable

/**
 * Navigation destination related to posts.
 */
sealed interface PostsNavDestination {

    /**
     * Navigation destination for list of blog posts.
     */
    @Serializable
    data object PostsList : PostsNavDestination

    /**
     * Navigation destination for a blog post.
     *
     * @property postId ID of the blog post.
     */
    @Serializable
    data class Post(val postId: String) : PostsNavDestination
}
