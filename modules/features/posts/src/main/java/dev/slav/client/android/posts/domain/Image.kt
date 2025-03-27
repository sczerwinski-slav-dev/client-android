package dev.slav.client.android.posts.domain

/**
 * Image details.
 *
 * @property name Name of the image.
 * @property type Type of the image.
 */
data class Image(
    val name: String,
    val type: String
) {

    /**
     * Return filename of this image with a given [size].
     *
     * @param size Image size.
     *
     * @return Image filename.
     */
    fun filename(size: ImageSize): String =
        "$name${size.qualifier}.$type"
}
