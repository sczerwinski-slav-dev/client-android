package dev.slav.client.android.common.network

import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber

/**
 * Timber logger for [HttpLoggingInterceptor].
 */
class TimberLogger : HttpLoggingInterceptor.Logger {

    /**
     * Log message from the interceptor.
     *
     * @param message Message to log.
     */
    override fun log(message: String) {
        timber.d(message)
    }

    companion object {
        private val timber: Timber.Tree
            get() = Timber.tag("Slav.Dev API")
    }
}
