package dev.slav.client.android.common.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineBreak
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
    lineBreak: LineBreak = LineBreak.Unspecified
): TextStyle =
    TextStyle(
        fontFamily = OpenSansFamily,
        fontWeight = fontWeight,
        fontSize = fontSize,
        lineHeight = lineHeight,
        letterSpacing = letterSpacing,
        lineBreak = lineBreak
    )

private fun headlineStyle(
    fontSize: TextUnit,
    lineHeight: TextUnit,
    letterSpacing: TextUnit = 0.sp,
): TextStyle =
    openSansStyle(
        fontWeight = FontWeight.Light,
        fontSize = fontSize,
        lineHeight = lineHeight,
        letterSpacing = letterSpacing,
        lineBreak = LineBreak.Heading
    )

private fun titleStyle(
    fontSize: TextUnit,
    lineHeight: TextUnit,
    letterSpacing: TextUnit = 0.sp,
): TextStyle =
    openSansStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = fontSize,
        lineHeight = lineHeight,
        letterSpacing = letterSpacing,
        lineBreak = LineBreak.Heading
    )

private fun bodyStyle(
    fontSize: TextUnit,
    lineHeight: TextUnit,
    letterSpacing: TextUnit = 0.sp,
): TextStyle =
    openSansStyle(
        fontWeight = FontWeight.Normal,
        fontSize = fontSize,
        lineHeight = lineHeight,
        letterSpacing = letterSpacing,
        lineBreak = LineBreak.Paragraph
    )

private fun labelStyle(
    fontSize: TextUnit,
    lineHeight: TextUnit,
    letterSpacing: TextUnit = 0.sp,
): TextStyle =
    openSansStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = fontSize,
        lineHeight = lineHeight,
        letterSpacing = letterSpacing,
        lineBreak = LineBreak.Simple
    )

val Typography = Typography(
    // Display:
    displayLarge = headlineStyle(fontSize = 57.sp, lineHeight = 64.sp),
    displayMedium = headlineStyle(fontSize = 45.sp, lineHeight = 52.sp),
    displaySmall = headlineStyle(fontSize = 36.sp, lineHeight = 44.sp),
    // Headline:
    headlineLarge = headlineStyle(fontSize = 32.sp, lineHeight = 40.sp),
    headlineMedium = headlineStyle(fontSize = 28.sp, lineHeight = 36.sp),
    headlineSmall = headlineStyle(fontSize = 24.sp, lineHeight = 32.sp),
    // Title:
    titleLarge = titleStyle(fontSize = 24.sp, lineHeight = 32.sp),
    titleMedium = titleStyle(fontSize = 22.sp, lineHeight = 28.sp),
    titleSmall = titleStyle(fontSize = 16.sp, lineHeight = 24.sp),
    // Body:
    bodyLarge = bodyStyle(fontSize = 22.sp, lineHeight = 28.sp),
    bodyMedium = bodyStyle(fontSize = 16.sp, lineHeight = 24.sp),
    bodySmall = bodyStyle(fontSize = 14.sp, lineHeight = 20.sp),
    // Label:
    labelLarge = labelStyle(fontSize = 16.sp, lineHeight = 24.sp),
    labelMedium = labelStyle(fontSize = 14.sp, lineHeight = 20.sp),
    labelSmall = labelStyle(fontSize = 12.sp, lineHeight = 16.sp),
)
