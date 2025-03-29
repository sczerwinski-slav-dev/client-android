package dev.slav.client.android.vm

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

/**
 * View model for main activity.
 */
@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    /**
     * System theme indicator.
     *
     * If `true`, system colors should be used
     * instead of application theme colors.
     */
    val systemTheme: Flow<Boolean>
        get() = flowOf(false)

    /**
     * Dark mode indicator.
     *
     * If `null`, system dark mode setting should be used.
     */
    val darkMode: Flow<Boolean?>
        get() = flowOf(true)
}
