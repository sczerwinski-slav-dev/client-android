package dev.slav.client.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import dagger.hilt.android.AndroidEntryPoint
import dev.slav.client.android.common.ui.theme.SlavDevTheme
import dev.slav.client.android.navigation.MainNavHost
import dev.slav.client.android.vm.MainViewModel

/**
 * Main (and only) activity of the application.
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val systemTheme by viewModel.systemTheme.collectAsState(initial = false)
            val darkMode by viewModel.darkMode.collectAsState(initial = null)

            SlavDevTheme(
                dynamicColor = systemTheme,
                darkTheme = darkMode
            ) {
                // Surface added to avoid background color change
                // during navigation transitions:
                Surface {
                    MainNavHost()
                }
            }
        }
    }
}
