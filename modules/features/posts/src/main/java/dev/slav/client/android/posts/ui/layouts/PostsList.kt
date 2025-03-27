package dev.slav.client.android.posts.ui.layouts

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.content.res.Configuration.UI_MODE_TYPE_NORMAL
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.slav.client.android.common.ui.layouts.SpacingLarge
import dev.slav.client.android.common.ui.layouts.SpacingMedium
import dev.slav.client.android.common.ui.preview.PreviewWrapper
import dev.slav.client.android.posts.domain.PostStub
import dev.slav.client.android.posts.ui.PreviewPosts

/**
 * List of blog posts.
 *
 * @param posts Stubs for blog posts.
 * @param modifier Modifier to be applied to this list.
 */
@Composable
fun PostsList(
    posts: List<PostStub>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(SpacingLarge),
        verticalArrangement = Arrangement.spacedBy(SpacingMedium)
    ) {
        items(items = posts, key = PostStub::id) { post ->
            PostCard(
                post = post,
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
fun PostsListPreviewDay() = PostsListPreview()

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES or UI_MODE_TYPE_NORMAL
)
@Composable
fun PostsListPreviewNight() = PostsListPreview()

@Composable
private fun PostsListPreview() {
    PreviewWrapper {
        PostsList(
            posts = PreviewPosts,
            modifier = Modifier.fillMaxSize()
        )
    }
}
