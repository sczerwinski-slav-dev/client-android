package dev.slav.client.android.posts.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import dev.slav.client.android.common.ui.components.containers.PullToRefreshContainer
import dev.slav.client.android.common.ui.preview.PreviewWrapper
import dev.slav.client.android.posts.R
import dev.slav.client.android.posts.domain.PostStub
import dev.slav.client.android.posts.navigation.PostsNavDestination
import dev.slav.client.android.posts.ui.layouts.PostsList
import dev.slav.client.android.posts.vm.PostsListViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * Posts list screen.
 *
 * @param snackbarHostState Snackbar host state used for error notifications.
 * @param navController Navigation controller used when navigating from this screen.
 * @param viewModel View model.
 */
@Composable
fun PostsListScreen(
    snackbarHostState: SnackbarHostState,
    navController: NavController,
    viewModel: PostsListViewModel = hiltViewModel()
) {
    val posts by viewModel.posts.collectAsState(initial = emptyList())
    val loading by viewModel.loading.collectAsState(initial = true)

    PostsListScreen(
        posts = posts,
        onPostClick = { post ->
            navController.navigate(
                PostsNavDestination.Post(postId = post.id)
            )
        },
        onRefresh = viewModel::loadPosts,
        loading = loading
    )

    PostsListScreenErrorEffect(
        snackbarHostState = snackbarHostState,
        error = viewModel.error
    )

    LaunchedEffect(true) {
        viewModel.loadPosts()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun PostsListScreen(
    posts: List<PostStub>,
    onPostClick: (PostStub) -> Unit,
    onRefresh: () -> Unit,
    loading: Boolean
) {
    PullToRefreshContainer(
        isRefreshing = loading,
        onRefresh = onRefresh,
        modifier = Modifier.fillMaxSize()
    ) {
        PostsList(
            posts = posts,
            onPostClick = onPostClick,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
private fun PostsListScreenErrorEffect(
    snackbarHostState: SnackbarHostState,
    error: Flow<Boolean>
) {
    val coroutineScope = rememberCoroutineScope()
    val errorMessage = stringResource(id = R.string.posts_list_error)

    LaunchedEffect(true) {
        coroutineScope.launch {
            error.collectLatest { error ->
                if (error) {
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar(
                            message = errorMessage,
                            duration = SnackbarDuration.Short
                        )
                    }
                }
            }
        }
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
        PostsListScreen(
            posts = PreviewPosts,
            onPostClick = {},
            onRefresh = {},
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
        PostsListScreen(
            posts = emptyList(),
            onPostClick = {},
            onRefresh = {},
            loading = true
        )
    }
}
