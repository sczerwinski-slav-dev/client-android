package dev.slav.client.android.posts.vm

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.slav.client.android.posts.domain.PostStub
import dev.slav.client.android.posts.ui.PreviewPosts
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

/**
 * View model for posts list screen.
 */
@HiltViewModel
class PostsListViewModel @Inject constructor() : ViewModel() {

    /**
     * All posts.
     */
    val posts: Flow<List<PostStub>> =
        flowOf(PreviewPosts) // TODO: Implement

    /**
     * Loading status.
     */
    val loading: Flow<Boolean> =
        flowOf(false) // TODO: Implement
}
