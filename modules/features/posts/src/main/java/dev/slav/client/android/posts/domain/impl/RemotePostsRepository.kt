package dev.slav.client.android.posts.domain.impl

import dagger.Reusable
import dev.slav.client.android.posts.domain.PostStub
import dev.slav.client.android.posts.domain.PostsRepository
import dev.slav.client.android.posts.network.PostsApi
import it.czerwinski.android.hilt.annotations.Bound
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

/**
 * Repository of blog posts using REST API.
 *
 * @see PostsRepository
 */
@Bound
@Reusable
class RemotePostsRepository @Inject constructor(
    private val postsApi: PostsApi
) : PostsRepository {

    override suspend fun findAll(): Result<List<PostStub>> =
        withContext(Dispatchers.IO) {
            postsApi.getPosts()
        }.onSuccess { posts ->
            timber.d("Fetched %d posts", posts.size)
        }.onFailure { throwable ->
            timber.e(throwable, "Error fetching posts")
        }

    companion object {

        private val timber: Timber.Tree
            get() = Timber.tag("PostsRepository")
    }
}
