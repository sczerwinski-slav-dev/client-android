package dev.slav.client.android.common.network.interceptors

import dev.slav.client.android.common.network.APIMediaType
import dev.slav.client.android.common.network.domain.ApplicationMetadata
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

/**
 * OkHttp interceptor adding default headers to the requests.
 */
class DefaultHeadersInterceptor @Inject constructor(
    private val applicationMetadata: ApplicationMetadata
) : Interceptor {

    private val userAgent: String by lazy {
        "%s/%s (%s) Android".format(
            applicationMetadata.name,
            applicationMetadata.versionName,
            applicationMetadata.buildType
        )
    }

    /**
     * Add default headers to the request and proceed.
     *
     * The headers include:
     * - User-Agent: &lt;application name&gt;/&lt;version name&gt; (&lt;build type&gt;) Android
     * - Accept: &lt;[APIMediaType]&gt;
     * - Cache-Control: no-cache
     *
     * @param chain Interceptor chain.
     *
     * @return Response.
     */
    override fun intercept(chain: Interceptor.Chain): Response = with(chain) {
        val request = request().newBuilder()
            .addHeader("User-Agent", userAgent)
            .addHeader("Accept", APIMediaType)
            .cacheControl(
                CacheControl.Builder()
                    .noCache()
                    .build()
            )
            .build()
        proceed(request)
    }
}
