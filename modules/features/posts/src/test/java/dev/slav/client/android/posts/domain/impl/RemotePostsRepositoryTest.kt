package dev.slav.client.android.posts.domain.impl

import dev.slav.client.android.posts.domain.PostStub
import dev.slav.client.android.posts.network.PostsApi
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.wheneverBlocking
import java.time.LocalDate

@DisplayName("Unit tests for RemotePostsRepository")
@ExtendWith(MockitoExtension::class)
class RemotePostsRepositoryTest {

    @Mock
    lateinit var postsApi: PostsApi

    @InjectMocks
    lateinit var classUnderTest: RemotePostsRepository

    @Test
    @DisplayName(
        "GIVEN successful response is returned by REST API, " +
            "WHEN I want to find all posts, " +
            "THEN return a success"
    )
    fun findAllShouldReturnSuccess() {
        wheneverBlocking { postsApi.getPosts() } doReturn Result.success(emptyList())

        val result = runBlocking { classUnderTest.findAll() }

        assertThat(result.isSuccess).isTrue
    }

    @Test
    @DisplayName(
        "GIVEN multiple posts are returned by REST API, " +
            "WHEN I want to find all posts, " +
            "THEN return posts as returned by API"
    )
    fun findAllShouldReturnCorrectListOfPosts() {
        wheneverBlocking { postsApi.getPosts() } doReturn Result.success(TestData.posts)

        val result = runBlocking { classUnderTest.findAll() }

        assertThat(result.getOrThrow())
            .isEqualTo(TestData.posts)
    }

    @Test
    @DisplayName(
        "GIVEN error response is returned by REST API, " +
            "WHEN I want to find all posts, " +
            "THEN return a failure"
    )
    fun findAllShouldReturnFailure() {
        wheneverBlocking {
            postsApi.getPosts()
        } doReturn Result.failure(RuntimeException("Test error"))

        val result = runBlocking { classUnderTest.findAll() }

        assertThat(result.isFailure).isTrue
    }

    @Test
    @DisplayName(
        "GIVEN error response is returned by REST API, " +
            "WHEN I want to find all posts, " +
            "THEN return error thrown by API"
    )
    fun findAllShouldReturnCorrectException() {
        val exception = RuntimeException("Test error")
        wheneverBlocking {
            postsApi.getPosts()
        } doReturn Result.failure(RuntimeException("Test error"))

        val result = runBlocking { classUnderTest.findAll() }

        assertThat(result.exceptionOrNull())
            .isEqualTo(exception)
    }

    private object TestData {
        val posts = listOf(
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
                id = "lorem-ipsum",
                title = "Lorem Ipsum",
                abstract = "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
                date = LocalDate.of(2025, 2, 15),
                draft = false,
                categories = listOf("lorem"),
                tags = listOf("ipsum"),
                image = null,
                url = "/api/posts/lorem-ipsum"
            )
        )
    }
}
