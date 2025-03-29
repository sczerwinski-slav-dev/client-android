package dev.slav.client.android.common.network.domain

/**
 * Application metadata.
 */
interface ApplicationMetadata {

    /**
     * Application name.
     */
    val name: String

    /**
     * Application package name.
     */
    val packageName: String

    /**
     * Application version.
     */
    val versionName: String

    /**
     * Application version code.
     */
    val versionCode: Int

    /**
     * Application build type.
     */
    val buildType: String
}
