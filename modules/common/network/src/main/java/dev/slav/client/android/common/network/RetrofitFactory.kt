package dev.slav.client.android.common.network

import com.skydoves.retrofit.adapters.result.ResultCallAdapterFactory
import dev.slav.client.android.common.network.serializers.LocalDateSerializer
import it.czerwinski.android.hilt.annotations.FactoryMethod
import kotlinx.serialization.StringFormat
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.contextual
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Singleton

/**
 * Retrofit factory.
 */
object RetrofitFactory {

    private const val BASE_URL = "https://slav.dev/api/"

    /**
     * Create a new retrofit instance.
     *
     * @param client OkHttp client.
     *
     * @return New retrofit instance.
     */
    @FactoryMethod
    @Singleton
    fun createRetrofit(client: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(createSerialFormat().asConverterFactory(getSerialMediaType()))
            .addCallAdapterFactory(ResultCallAdapterFactory.create())
            .build()

    private fun createSerialFormat(): StringFormat =
        Json {
            serializersModule = SerializersModule {
                contextual(LocalDateSerializer)
            }
        }

    private fun getSerialMediaType(): MediaType =
        APIMediaType.toMediaType()
}
