package dev.slav.client.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import dev.slav.client.android.common.ui.theme.SlavDevTheme
import dev.slav.client.android.navigation.MainNavHost

/**
 * Main (and only) activity of the application.
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SlavDevTheme(
                dynamicColor = false,
                darkTheme = true
            ) {
                MainNavHost()
            }
        }
    }
}
