package dev.slav.client.android.posts.ui

import androidx.compose.ui.test.DeviceConfigurationOverride
import androidx.compose.ui.test.Locales
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.text.intl.LocaleList
import de.mannodermaus.junit5.compose.AndroidComposeExtension
import de.mannodermaus.junit5.compose.ComposeExtension
import dev.slav.client.android.common.ui.theme.SlavDevTheme
import dev.slav.client.android.posts.domain.PostStub
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.time.LocalDate

@DisplayName("Instrumented tests for PostsListScreen")
@ExtendWith(AndroidComposeExtension::class)
class PostsListScreenTest {

    @Test
    @DisplayName(
        "GIVEN there is a single post provided, " +
            "WHEN I open the list of posts, " +
            "THEN I should see a card with details of this post"
    )
    fun shouldDisplayPostCard(extension: ComposeExtension) = extension.use {
        setContent {
            DeviceConfigurationOverride(
                DeviceConfigurationOverride.Locales(LocaleList("en-rUK"))
            ) {
                SlavDevTheme {
                    PostsListScreen(
                        posts = listOf(TestData.post),
                        onPostClick = {},
                        onRefresh = {},
                        loading = false
                    )
                }
            }
        }

        onNodeWithTag("hello-world")
            .assertIsDisplayed()
    }

    @Test
    @DisplayName(
        "GIVEN there is a single post provided, " +
            "WHEN I open the list of posts, " +
            "THEN I should see the title of the post"
    )
    fun shouldDisplayPostTitle(extension: ComposeExtension) = extension.use {
        setContent {
            DeviceConfigurationOverride(
                DeviceConfigurationOverride.Locales(LocaleList("en-rUK"))
            ) {
                SlavDevTheme {
                    PostsListScreen(
                        posts = listOf(TestData.post),
                        onPostClick = {},
                        onRefresh = {},
                        loading = false
                    )
                }
            }
        }

        onNodeWithText("Hello, World!")
            .assertIsDisplayed()
    }

    @Test
    @DisplayName(
        "GIVEN there is a single post provided, " +
            "WHEN I open the list of posts, " +
            "THEN I should see the date of the post publication"
    )
    fun shouldDisplayPostDate(extension: ComposeExtension) = extension.use {
        setContent {
            DeviceConfigurationOverride(
                DeviceConfigurationOverride.Locales(LocaleList("en-rUK"))
            ) {
                SlavDevTheme {
                    PostsListScreen(
                        posts = listOf(TestData.post),
                        onPostClick = {},
                        onRefresh = {},
                        loading = false
                    )
                }
            }
        }

        onNodeWithText("5 March 2025")
            .assertIsDisplayed()
    }

    @Test
    @DisplayName(
        "GIVEN there is a single post provided, " +
            "WHEN I open the list of posts, " +
            "THEN I should see the list of categories of the post"
    )
    fun shouldDisplayPostCategories(extension: ComposeExtension) = extension.use {
        setContent {
            DeviceConfigurationOverride(
                DeviceConfigurationOverride.Locales(LocaleList("en-rUK"))
            ) {
                SlavDevTheme {
                    PostsListScreen(
                        posts = listOf(TestData.post),
                        onPostClick = {},
                        onRefresh = {},
                        loading = false
                    )
                }
            }
        }

        onNodeWithText("kotlin")
            .assertIsDisplayed()
        onNodeWithText("android")
            .assertIsDisplayed()
    }

    @Test
    @DisplayName(
        "GIVEN there is a single post provided, " +
            "WHEN I open the list of posts, " +
            "THEN I should see the list of tags of the post"
    )
    fun shouldDisplayPostTags(extension: ComposeExtension) = extension.use {
        setContent {
            DeviceConfigurationOverride(
                DeviceConfigurationOverride.Locales(LocaleList("en-rUK"))
            ) {
                SlavDevTheme {
                    PostsListScreen(
                        posts = listOf(TestData.post),
                        onPostClick = {},
                        onRefresh = {},
                        loading = false
                    )
                }
            }
        }

        onNodeWithText("hello")
            .assertIsDisplayed()
        onNodeWithText("world")
            .assertIsDisplayed()
    }

    @Test
    @DisplayName(
        "GIVEN there is a single post provided, " +
            "WHEN I open the list of posts, " +
            "THEN I should see the abstract of the post"
    )
    fun shouldDisplayPostAbstract(extension: ComposeExtension) = extension.use {
        setContent {
            DeviceConfigurationOverride(
                DeviceConfigurationOverride.Locales(LocaleList("en-rUK"))
            ) {
                SlavDevTheme {
                    PostsListScreen(
                        posts = listOf(TestData.post),
                        onPostClick = {},
                        onRefresh = {},
                        loading = false
                    )
                }
            }
        }

        onNodeWithText("How to write \"Hello, World!\" application")
            .assertIsDisplayed()
    }

    private object TestData {
        val post = PostStub(
            id = "hello-world",
            title = "Hello, World!",
            abstract = "How to write \"Hello, World!\" application",
            date = LocalDate.of(2025, 3, 5),
            draft = false,
            categories = listOf("kotlin", "android"),
            tags = listOf("hello", "world"),
            image = null,
            url = "/api/posts/hello-world"
        )
    }
}
