package dev.slav.client.android.common.ui.components.text

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.content.res.Configuration.UI_MODE_TYPE_NORMAL
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import dev.slav.client.android.common.ui.preview.PreviewWrapper

/**
 * Large body text.
 *
 * @param text Text of the body.
 * @param modifier Modifier to be applied to this text.
 * @param overflow Text overflow handling strategy.
 * @param maxLines Maximum number of lines to be displayed.
 */
@Composable
fun BodyLarge(
    text: String,
    modifier: Modifier = Modifier,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
) {
    Text(
        text = text,
        modifier = modifier,
        style = MaterialTheme.typography.bodyLarge,
        overflow = overflow,
        maxLines = maxLines
    )
}

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO or UI_MODE_TYPE_NORMAL
)
@Composable
fun BodyLargePreviewDay() = BodyLargePreview()

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES or UI_MODE_TYPE_NORMAL
)
@Composable
fun BodyLargePreviewNight() = BodyLargePreview()

@Composable
private fun BodyLargePreview() {
    PreviewWrapper {
        BodyLarge("Lorem ipsum dolor sit amet,\nconsectetur adipiscing elit")
    }
}
