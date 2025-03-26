package dev.slav.client.android.common.ui.preview

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import dev.slav.client.android.common.ui.theme.SlavDevTheme

@Composable
fun PreviewWrapper(
    content: @Composable () -> Unit
) {
    SlavDevTheme {
        Surface(
            color = MaterialTheme.colorScheme.background,
            content = content
        )
    }
}
