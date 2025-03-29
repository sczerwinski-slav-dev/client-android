package dev.slav.client.android.common.ui.layouts

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.content.res.Configuration.UI_MODE_TYPE_NORMAL
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.slav.client.android.common.ui.components.text.TitleLarge
import dev.slav.client.android.common.ui.preview.PreviewWrapper

@Composable
fun Placeholder(
    text: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {
        Box(contentAlignment = Alignment.Center) {
            TitleLarge(text = text)
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO or UI_MODE_TYPE_NORMAL
)
@Composable
fun PlaceholderPreviewDay() = PlaceholderPreview()

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES or UI_MODE_TYPE_NORMAL
)
@Composable
fun PlaceholderPreviewNight() = PlaceholderPreview()

@Composable
private fun PlaceholderPreview() {
    PreviewWrapper {
        Placeholder(
            text = "Lorem Ipsum",
            modifier = Modifier.fillMaxSize()
        )
    }
}
