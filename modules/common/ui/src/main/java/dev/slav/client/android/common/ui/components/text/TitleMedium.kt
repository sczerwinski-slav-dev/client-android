package dev.slav.client.android.common.ui.components.text

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.content.res.Configuration.UI_MODE_TYPE_NORMAL
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.slav.client.android.common.ui.preview.PreviewWrapper

/**
 * Medium title text.
 *
 * @param text Text of the title.
 * @param modifier Modifier to be applied to this text.
 */
@Composable
fun TitleMedium(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        modifier = modifier,
        style = MaterialTheme.typography.titleMedium
    )
}

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO or UI_MODE_TYPE_NORMAL
)
@Composable
fun TitleMediumPreviewDay() = TitleMediumPreview()

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES or UI_MODE_TYPE_NORMAL
)
@Composable
fun TitleMediumPreviewNight() = TitleMediumPreview()

@Composable
private fun TitleMediumPreview() {
    PreviewWrapper {
        TitleMedium("Lorem Ipsum\nDolor Sit Amet")
    }
}
