package dev.slav.client.android.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.content.res.Configuration.UI_MODE_TYPE_NORMAL
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import dev.slav.client.android.R
import dev.slav.client.android.common.ui.components.text.TitleLarge
import dev.slav.client.android.common.ui.preview.PreviewWrapper

/**
 * Home screen app bar.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenAppBar() {
    TopAppBar(
        title = { TitleLarge(text = stringResource(id = R.string.app_name)) },
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
    )
}

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO or UI_MODE_TYPE_NORMAL
)
@Composable
fun HomeScreenAppBarPreviewDay() = HomeScreenAppBarPreview()

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES or UI_MODE_TYPE_NORMAL
)
@Composable
fun HomeScreenAppBarPreviewNight() = HomeScreenAppBarPreview()

@Composable
private fun HomeScreenAppBarPreview() {
    PreviewWrapper {
        HomeScreenAppBar()
    }
}
