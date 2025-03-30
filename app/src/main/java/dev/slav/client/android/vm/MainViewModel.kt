package dev.slav.client.android.vm

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.slav.client.android.settings.domain.Settings
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * View model for main activity.
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val settings: Settings
) : ViewModel() {

    /**
     * System theme indicator.
     *
     * If `true`, system colors should be used
     * instead of application theme colors.
     */
    val systemTheme: Flow<Boolean>
        get() = settings.systemTheme

    /**
     * Dark mode indicator.
     *
     * If `null`, system dark mode setting should be used.
     */
    val darkMode: Flow<Boolean?>
        get() = settings.darkMode
}
