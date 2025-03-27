package dev.slav.client.android.posts.domain

import java.time.LocalDate

/**
 * Stub for a blog post.
 *
 * @property id Unique identifier of this post.
 * @property title Title of this post.
 * @property abstract Abstract of this post.
 * @property date Publication date of this post.
 * @property draft Draft status of this post.
 * @property categories Categories of this post.
 * @property tags Tags of this post.
 * @property image Hero image of this post.
 * @property url Path to this post resource.
 */
data class PostStub(
    val id: String,
    val title: String,
    val abstract: String,
    val date: LocalDate,
    val draft: Boolean,
    val categories: List<String>,
    val tags: List<String>,
    val image: Image?,
    val url: String,
)
