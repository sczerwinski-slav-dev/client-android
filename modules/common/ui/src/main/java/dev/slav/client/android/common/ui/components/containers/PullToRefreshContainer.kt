package dev.slav.client.android.common.ui.components.containers

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.content.res.Configuration.UI_MODE_TYPE_NORMAL
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.Indicator
import androidx.compose.material3.pulltorefresh.PullToRefreshState
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.slav.client.android.common.ui.components.text.BodyLarge
import dev.slav.client.android.common.ui.components.text.TitleLarge
import dev.slav.client.android.common.ui.layouts.CardContent
import dev.slav.client.android.common.ui.preview.PreviewWrapper

/**
 * Pull to refresh container with primary color indicator.
 *
 * @param modifier Modifier to be applied to this node.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PullToRefreshContainer(
    isRefreshing: Boolean,
    onRefresh: () -> Unit,
    modifier: Modifier = Modifier,
    state: PullToRefreshState = rememberPullToRefreshState(),
    content: @Composable BoxScope.() -> Unit
) {
    PullToRefreshBox(
        isRefreshing = isRefreshing,
        onRefresh = onRefresh,
        modifier = modifier,
        state = state,
        indicator = {
            Indicator(
                modifier = Modifier.align(Alignment.TopCenter),
                isRefreshing = isRefreshing,
                state = state,
                color = MaterialTheme.colorScheme.primary
            )
        },
        content = content
    )
}

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO or UI_MODE_TYPE_NORMAL
)
@Composable
fun PullToRefreshContainerPreviewDay() = PullToRefreshContainerPreview()

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES or UI_MODE_TYPE_NORMAL
)
@Composable
fun PullToRefreshContainerPreviewNight() = PullToRefreshContainerPreview()

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PullToRefreshContainerPreview() {
    PreviewWrapper {
        PullToRefreshContainer(
            isRefreshing = true,
            onRefresh = {},
            modifier = Modifier.fillMaxSize()
        ) {
            CardContent {
                TitleLarge(text = "Lorem Ipsum")
                BodyLarge(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit")
            }
        }
    }
}
