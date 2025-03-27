package dev.slav.client.android.posts.domain

/**
 * Size of an image.
 *
 * @property qualifier Qualifier used to determine image filename.
 *
 * @see Image
 */
enum class ImageSize(
    internal val qualifier: String
) {
    /**
     * Image thumbnail.
     */
    Thumbnail(qualifier = "-thumb"),

    /**
     * Small image.
     */
    Small(qualifier = ""),

    /**
     * Medium image.
     */
    Medium(qualifier = "@2"),

    /**
     * Large image.
     */
    Large(qualifier = "@3");
}
