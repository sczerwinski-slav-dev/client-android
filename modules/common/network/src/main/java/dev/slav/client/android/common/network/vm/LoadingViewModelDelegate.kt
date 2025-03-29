package dev.slav.client.android.common.network.vm

import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.debounce
import timber.log.Timber

/**
 * Delegate of loading view model interface.
 *
 * Any view model can delegate its [LoadingViewModel] interface to this implementation.
 */
class LoadingViewModelDelegate : LoadingViewModel {

    private val _loading = MutableStateFlow(false)

    @OptIn(FlowPreview::class)
    override val loading: Flow<Boolean>
        get() = _loading.debounce { state -> if (state) 0L else LOADING_DELAY_MILLIS }

    override suspend fun <T> withLoading(block: suspend () -> T): T {
        timber.d("Loading started")
        _loading.emit(true)

        val result = block()

        timber.d("Loading finished")
        _loading.emit(false)

        return result
    }

    companion object {
        private const val LOADING_DELAY_MILLIS = 600L

        private val timber: Timber.Tree
            get() = Timber.tag("LoadingViewModel")
    }
}
