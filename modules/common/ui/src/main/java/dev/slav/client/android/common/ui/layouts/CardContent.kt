package dev.slav.client.android.common.ui.layouts

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.content.res.Configuration.UI_MODE_TYPE_NORMAL
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.slav.client.android.common.ui.components.text.BodyLarge
import dev.slav.client.android.common.ui.components.text.TitleLarge
import dev.slav.client.android.common.ui.preview.PreviewWrapper

/**
 * Wrapper for card content.
 *
 * Arranges nodes inside the card in a column.
 * Adds appropriate padding and spacing to the layout.
 *
 * @param modifier Modifier to be applied to this container.
 * @param content Content of this container.
 */
@Composable
fun CardContent(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = modifier then Modifier.padding(SpacingLarge),
        verticalArrangement = Arrangement.spacedBy(SpacingSmall),
        content = content
    )
}

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO or UI_MODE_TYPE_NORMAL
)
@Composable
fun CardContentPreviewDay() = CardContentPreview()

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES or UI_MODE_TYPE_NORMAL
)
@Composable
fun CardContentPreviewNight() = CardContentPreview()

@Composable
private fun CardContentPreview() {
    PreviewWrapper {
        CardContent(
            modifier = Modifier.fillMaxWidth()
        ) {
            TitleLarge(text = "Lorem Ipsum")
            BodyLarge(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit")
        }
    }
}
