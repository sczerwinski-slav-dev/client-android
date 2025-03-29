package dev.slav.client.android.common.network.vm

import kotlinx.coroutines.flow.Flow

/**
 * Interface implemented by view models that perform long loading operations.
 */
interface LoadingViewModel {

    /**
     * Loading status.
     */
    val loading: Flow<Boolean>

    /**
     * Executes given [block] with loading.
     *
     * @param block Block to be executed while loading.
     *
     * @return Result returned by the [block].
     */
    suspend fun<T> withLoading(block: suspend () -> T): T
}
