package dev.slav.client.android.posts.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.slav.client.android.common.network.vm.LoadingViewModel
import dev.slav.client.android.common.network.vm.LoadingViewModelDelegate
import dev.slav.client.android.posts.domain.PostStub
import dev.slav.client.android.posts.domain.PostsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * View model for posts list screen.
 */
@HiltViewModel
class PostsListViewModel @Inject constructor(
    private val postsRepository: PostsRepository
) : ViewModel(),
    LoadingViewModel by LoadingViewModelDelegate() {

    private val _posts = MutableStateFlow<List<PostStub>>(emptyList())
    private val _error = MutableStateFlow(false)

    /**
     * All posts.
     */
    val posts: Flow<List<PostStub>>
        get() = _posts

    /**
     * Error state.
     */
    val error: Flow<Boolean>
        get() = _error

    /**
     * Load blog posts into this view model.
     */
    fun loadPosts() {
        viewModelScope.launch {
            _error.emit(false)
            withLoading {
                postsRepository.findAll()
                    .onSuccess { posts -> _posts.emit(posts) }
                    .onFailure { throwable -> _error.emit(true) }
            }
        }
    }
}
