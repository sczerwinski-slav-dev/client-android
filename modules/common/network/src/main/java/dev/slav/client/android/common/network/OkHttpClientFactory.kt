package dev.slav.client.android.common.network

import dev.slav.client.android.common.network.interceptors.DefaultHeadersInterceptor
import it.czerwinski.android.hilt.annotations.FactoryMethod
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

/**
 * OkHttp client factory.
 */
object OkHttpClientFactory {

    /**
     * Create a new instance of OkHttp client.
     *
     * @return New instance of OkHttp client.
     */
    @FactoryMethod
    fun createOkHttpClient(
        defaultHeadersInterceptor: DefaultHeadersInterceptor
    ): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(defaultHeadersInterceptor)
            .addInterceptor(
                HttpLoggingInterceptor(TimberLogger())
                    .setLevel(HttpLoggingInterceptor.Level.BODY)
            )
            .build()
}
