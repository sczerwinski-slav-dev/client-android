package dev.slav.client.android.posts.ui

import dev.slav.client.android.posts.domain.PostStub
import java.time.LocalDate

/**
 * Dummy list of posts to display in previews.
 */
@Suppress("MagicNumber")
val PreviewPosts: List<PostStub> = listOf(
    PostStub(
        id = "hello-world",
        title = "Hello, World!",
        abstract = "How to write \"Hello, World!\" application",
        date = LocalDate.of(2025, 3, 5),
        draft = false,
        categories = listOf("kotlin", "android"),
        tags = listOf("hello", "world", "howto", "tutorial"),
        image = null,
        url = "/api/posts/hello-world"
    ),
    PostStub(
        id = "lorem-ipsum-1",
        title = "Lorem Ipsum 1",
        abstract = "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
        date = LocalDate.of(2025, 2, 15),
        draft = false,
        categories = listOf("lorem"),
        tags = listOf("ipsum"),
        image = null,
        url = "/api/posts/lorem-ipsum-1"
    ),
    PostStub(
        id = "lorem-ipsum-2",
        title = "Lorem Ipsum 2",
        abstract = "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
        date = LocalDate.of(2025, 2, 15),
        draft = false,
        categories = listOf("lorem"),
        tags = listOf("ipsum"),
        image = null,
        url = "/api/posts/lorem-ipsum-2"
    ),
    PostStub(
        id = "lorem-ipsum-3",
        title = "Lorem Ipsum 3",
        abstract = "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
        date = LocalDate.of(2025, 2, 15),
        draft = false,
        categories = listOf("lorem"),
        tags = listOf("ipsum"),
        image = null,
        url = "/api/posts/lorem-ipsum-2"
    ),
    PostStub(
        id = "lorem-ipsum-4",
        title = "Lorem Ipsum 4",
        abstract = "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
        date = LocalDate.of(2025, 2, 15),
        draft = false,
        categories = listOf("lorem"),
        tags = listOf("ipsum"),
        image = null,
        url = "/api/posts/lorem-ipsum-2"
    )
)
