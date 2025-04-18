package dev.slav.client.android.common.ui.theme

import android.os.Build
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Blue500,
    secondary = Orange300,
    tertiary = DeepOrange400
)

private val LightColorScheme = lightColorScheme(
    primary = Blue700,
    secondary = Orange800,
    tertiary = DeepOrange800
)

/**
 * Slav.Dev application theme.
 */
@Composable
fun SlavDevTheme(
    darkTheme: Boolean? = null,
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val darkTheme = darkTheme ?: isSystemInDarkTheme()
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )

    EdgeToEdgeEffect(darkTheme = darkTheme)
}

@Composable
private fun EdgeToEdgeEffect(
    darkTheme: Boolean
) {
    val systemBarStyle = if (darkTheme) {
        SystemBarStyle.dark(
            scrim = DarkColorScheme.background.toArgb()
        )
    } else {
        SystemBarStyle.light(
            scrim = LightColorScheme.background.toArgb(),
            darkScrim = DarkColorScheme.background.toArgb()
        )
    }

    val activity = LocalContext.current as? ComponentActivity

    DisposableEffect(darkTheme) {
        activity?.enableEdgeToEdge(
            statusBarStyle = systemBarStyle,
            navigationBarStyle = systemBarStyle
        )

        onDispose {}
    }
}
