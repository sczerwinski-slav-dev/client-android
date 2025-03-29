package dev.slav.client.android.domain

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import dev.slav.client.android.BuildConfig
import dev.slav.client.android.R
import dev.slav.client.android.common.network.domain.ApplicationMetadata
import it.czerwinski.android.hilt.annotations.Bound
import it.czerwinski.android.hilt.getValue
import javax.inject.Inject
import javax.inject.Provider

/**
 * Slav.Dev application metadata.
 *
 * @see ApplicationMetadata
 */
@Bound
class SlavDevApplicationMetadata @Inject constructor(
    @ApplicationContext private val contextProvider: Provider<Context>
) : ApplicationMetadata {

    private val context: Context by contextProvider

    override val name: String
        get() = context.getString(R.string.app_name)

    override val packageName: String
        get() = BuildConfig.APPLICATION_ID

    override val versionName: String
        get() = BuildConfig.VERSION_NAME

    override val versionCode: Int
        get() = BuildConfig.VERSION_CODE

    override val buildType: String
        get() = BuildConfig.BUILD_TYPE
}
