package dev.slav.client.android.common.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import dev.slav.client.android.common.ui.R

private val OpenSansFont = Font(R.font.open_sans)
private val OpenSansFamily = FontFamily(OpenSansFont)

private fun openSansStyle(
    fontWeight: FontWeight?,
    fontSize: TextUnit,
    lineHeight: TextUnit,
    letterSpacing: TextUnit = 0.sp,
) : TextStyle =
    TextStyle(
        fontFamily = OpenSansFamily,
        fontWeight = fontWeight,
        fontSize = fontSize,
        lineHeight = lineHeight,
        letterSpacing = letterSpacing,
    )

private fun openSansLightStyle(
    fontSize: TextUnit,
    lineHeight: TextUnit,
    letterSpacing: TextUnit = 0.sp,
) : TextStyle =
    openSansStyle(
        fontWeight = FontWeight.Light,
        fontSize = fontSize,
        lineHeight = lineHeight,
        letterSpacing = letterSpacing,
    )

private fun openSansNormalStyle(
    fontSize: TextUnit,
    lineHeight: TextUnit,
    letterSpacing: TextUnit = 0.sp,
) : TextStyle =
    openSansStyle(
        fontWeight = FontWeight.Normal,
        fontSize = fontSize,
        lineHeight = lineHeight,
        letterSpacing = letterSpacing,
    )

private fun openSansMediumStyle(
    fontSize: TextUnit,
    lineHeight: TextUnit,
    letterSpacing: TextUnit = 0.sp,
) : TextStyle =
    openSansStyle(
        fontWeight = FontWeight.Medium,
        fontSize = fontSize,
        lineHeight = lineHeight,
        letterSpacing = letterSpacing,
    )

val Typography = Typography(
    // Display:
    displayLarge = openSansLightStyle(fontSize = 57.sp, lineHeight = 64.sp),
    displayMedium = openSansLightStyle(fontSize = 45.sp, lineHeight = 52.sp),
    displaySmall = openSansLightStyle(fontSize = 36.sp, lineHeight = 44.sp),
    // Headline:
    headlineLarge = openSansLightStyle(fontSize = 32.sp, lineHeight = 40.sp),
    headlineMedium = openSansLightStyle(fontSize = 28.sp, lineHeight = 36.sp),
    headlineSmall = openSansLightStyle(fontSize = 24.sp, lineHeight = 32.sp),
    // Title:
    titleLarge = openSansMediumStyle(fontSize = 22.sp, lineHeight = 28.sp),
    titleMedium = openSansMediumStyle(fontSize = 16.sp, lineHeight = 24.sp),
    titleSmall = openSansMediumStyle(fontSize = 14.sp, lineHeight = 20.sp),
    // Body:
    bodyLarge = openSansNormalStyle(fontSize = 16.sp, lineHeight = 24.sp),
    bodyMedium = openSansNormalStyle(fontSize = 14.sp, lineHeight = 20.sp),
    bodySmall = openSansNormalStyle(fontSize = 12.sp, lineHeight = 16.sp),
    // Label:
    labelLarge = openSansMediumStyle(fontSize = 14.sp, lineHeight = 20.sp),
    labelMedium = openSansMediumStyle(fontSize = 12.sp, lineHeight = 16.sp),
    labelSmall = openSansMediumStyle(fontSize = 11.sp, lineHeight = 16.sp),
)
