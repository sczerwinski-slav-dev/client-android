package dev.slav.client.android.posts.domain

/**
 * Repository of blog posts.
 */
interface PostsRepository {

    /**
     * Return stubs for all blog posts.
     *
     * @return Stubs for all blog posts.
     */
    suspend fun findAll(): Result<List<PostStub>>
}
