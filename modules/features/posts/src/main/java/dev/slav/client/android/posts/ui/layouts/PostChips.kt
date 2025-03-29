package dev.slav.client.android.posts.ui.layouts

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.content.res.Configuration.UI_MODE_TYPE_NORMAL
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.material3.ElevatedSuggestionChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.slav.client.android.common.ui.components.text.LabelMedium
import dev.slav.client.android.common.ui.layouts.SpacingSmall
import dev.slav.client.android.common.ui.preview.PreviewWrapper
import dev.slav.client.android.posts.domain.PostStub
import dev.slav.client.android.posts.ui.PreviewPosts

/**
 * Chips describing categories and tags of a blog post.
 *
 * @param post Stub for a blog post.
 * @param modifier Modifier to be applied to this node.
 */
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PostChips(
    post: PostStub,
    modifier: Modifier = Modifier
) {
    FlowRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(SpacingSmall),
    ) {
        for (category in post.categories) {
            CategoryChip(category = category)
        }
        for (tag in post.tags) {
            TagChip(tag = tag)
        }
    }
}

@Composable
private fun CategoryChip(
    category: String
) {
    ElevatedSuggestionChip(
        onClick = {},
        label = { LabelMedium(text = category) },
        colors = SuggestionChipDefaults.elevatedSuggestionChipColors(
            containerColor = MaterialTheme.colorScheme.primary,
            labelColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}

@Composable
private fun TagChip(
    tag: String
) {
    ElevatedSuggestionChip(
        onClick = {},
        label = { LabelMedium(text = tag) }
    )
}

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO or UI_MODE_TYPE_NORMAL
)
@Composable
fun PostChipsPreviewDay() = PostChipsPreview()

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES or UI_MODE_TYPE_NORMAL
)
@Composable
fun PostChipsPreviewNight() = PostChipsPreview()

@Composable
private fun PostChipsPreview() {
    PreviewWrapper {
        PostChips(
            post = PreviewPosts.first()
        )
    }
}
