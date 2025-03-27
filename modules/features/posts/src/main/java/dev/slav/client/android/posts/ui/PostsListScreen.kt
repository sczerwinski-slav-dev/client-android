package dev.slav.client.android.posts.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import dev.slav.client.android.common.ui.preview.PreviewWrapper
import dev.slav.client.android.posts.domain.PostStub
import dev.slav.client.android.posts.ui.layouts.PostsList
import dev.slav.client.android.posts.vm.PostsListViewModel

/**
 * Posts list screen.
 *
 * @param navController Navigation controller used when navigating from this screen.
 * @param viewModel View model.
 */
@Composable
fun PostsListScreen(
    @Suppress("UnusedParameter") navController: NavController,
    viewModel: PostsListViewModel = hiltViewModel()
) {
    val posts by viewModel.posts.collectAsState(initial = emptyList())
    val loading by viewModel.loading.collectAsState(initial = true)

    PostsListScreenContent(
        posts = posts,
        loading = loading
    )
}

@Composable
private fun PostsListScreenContent(
    posts: List<PostStub>,
    loading: Boolean
) {
    if (loading) {
        LinearProgressIndicator(
            modifier = Modifier.fillMaxWidth()
        )
    } else {
        PostsList(
            posts = posts,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun PostsListScreenContentPreviewDay() = PostsListScreenContentPreview()

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun PostsListScreenContentPreviewNight() = PostsListScreenContentPreview()

@Composable
private fun PostsListScreenContentPreview() {
    PreviewWrapper {
        PostsListScreenContent(
            posts = PreviewPosts,
            loading = false
        )
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun PostsListScreenContentLoadingPreviewDay() = PostsListScreenContentLoadingPreview()

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun PostsListScreenContentLoadingPreviewNight() = PostsListScreenContentLoadingPreview()

@Composable
private fun PostsListScreenContentLoadingPreview() {
    PreviewWrapper {
        PostsListScreenContent(
            posts = emptyList(),
            loading = true
        )
    }
}
