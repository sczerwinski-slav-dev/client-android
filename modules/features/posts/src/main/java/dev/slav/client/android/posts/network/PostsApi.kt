package dev.slav.client.android.posts.network

import dev.slav.client.android.posts.domain.PostStub
import it.czerwinski.android.hilt.annotations.FactoryMethod
import retrofit2.Retrofit
import retrofit2.create
import retrofit2.http.GET
import javax.inject.Singleton

/**
 * REST API for blog posts.
 */
interface PostsApi {

    /**
     * Return stubs for all blog posts.
     *
     * @return Stubs for all blog posts or error.
     */
    @GET("posts")
    suspend fun getPosts(): Result<List<PostStub>>

    /**
     * Factory of blog posts API.
     */
    object Factory {

        /**
         * Create a new instance of blog posts API.
         *
         * @param retrofit Retrofit instance.
         *
         * @return New instance of blog posts API.
         */
        @FactoryMethod
        @Singleton
        fun create(retrofit: Retrofit): PostsApi =
            retrofit.create()
    }
}
