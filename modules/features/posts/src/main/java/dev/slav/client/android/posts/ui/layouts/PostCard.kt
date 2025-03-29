package dev.slav.client.android.posts.ui.layouts

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.content.res.Configuration.UI_MODE_TYPE_NORMAL
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import dev.slav.client.android.common.ui.components.text.BodyLarge
import dev.slav.client.android.common.ui.components.text.LabelLarge
import dev.slav.client.android.common.ui.components.text.Secondary
import dev.slav.client.android.common.ui.components.text.TitleLarge
import dev.slav.client.android.common.ui.formatting.formatLongDate
import dev.slav.client.android.common.ui.layouts.CardContent
import dev.slav.client.android.common.ui.preview.PreviewWrapper
import dev.slav.client.android.posts.domain.PostStub
import dev.slav.client.android.posts.ui.PreviewPosts

/**
 * Card containing basic information about a blog post.
 *
 * @param post Stub for a blog post.
 * @param modifier Modifier to be applied to this card.
 */
@Composable
fun PostCard(
    post: PostStub,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = onClick,
        modifier = modifier then Modifier.testTag(post.id)
    ) {
        CardContent {
            TitleLarge(
                text = post.title,
                modifier = Modifier.fillMaxWidth()
            )
            Secondary {
                LabelLarge(
                    text = post.date.formatLongDate(),
                    modifier = Modifier.fillMaxWidth()
                )
            }
            PostChips(
                post = post,
                modifier = Modifier.fillMaxWidth()
            )
            BodyLarge(
                text = post.abstract,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO or UI_MODE_TYPE_NORMAL
)
@Composable
fun PostCardPreviewDay() = PostCardPreview()

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES or UI_MODE_TYPE_NORMAL
)
@Composable
fun PostCardPreviewNight() = PostCardPreview()

@Composable
private fun PostCardPreview() {
    PreviewWrapper {
        PostCard(
            post = PreviewPosts.first(),
            onClick = {},
            modifier = Modifier.fillMaxWidth()
        )
    }
}
