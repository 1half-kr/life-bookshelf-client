package com.tdd.bookshelf.core.designsystem

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import bookshelf.composeapp.generated.resources.Pretendard_Black
import bookshelf.composeapp.generated.resources.Pretendard_Bold
import bookshelf.composeapp.generated.resources.Pretendard_ExtraBold
import bookshelf.composeapp.generated.resources.Pretendard_ExtraLight
import bookshelf.composeapp.generated.resources.Pretendard_Light
import bookshelf.composeapp.generated.resources.Pretendard_Medium
import bookshelf.composeapp.generated.resources.Pretendard_Regular
import bookshelf.composeapp.generated.resources.Pretendard_SemiBold
import bookshelf.composeapp.generated.resources.Pretendard_Thin
import bookshelf.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Font

@OptIn(ExperimentalResourceApi::class)
@Composable
fun setFont(): FontFamily = FontFamily(
    Font(Res.font.Pretendard_Black, FontWeight.Black),
    Font(Res.font.Pretendard_Bold, FontWeight.Bold),
    Font(Res.font.Pretendard_ExtraBold, FontWeight.ExtraBold),
    Font(Res.font.Pretendard_ExtraLight, FontWeight.ExtraLight),
    Font(Res.font.Pretendard_Light, FontWeight.Light),
    Font(Res.font.Pretendard_Medium, FontWeight.Medium),
    Font(Res.font.Pretendard_Regular, FontWeight.Normal),
    Font(Res.font.Pretendard_SemiBold, FontWeight.SemiBold),
    Font(Res.font.Pretendard_Thin, FontWeight.Thin)
)

object BookShelfTypo {
    val Black: TextStyle
        @Composable get() = TextStyle(
            fontFamily = setFont(),
            fontWeight = FontWeight.Black
        )

    val Bold: TextStyle
        @Composable get() = TextStyle(
            fontFamily = setFont(),
            fontWeight = FontWeight.Bold
        )

    val ExtraBold: TextStyle
        @Composable get() = TextStyle(
            fontFamily = setFont(),
            fontWeight = FontWeight.ExtraBold
        )

    val ExtraLight: TextStyle
        @Composable get() = TextStyle(
            fontFamily = setFont(),
            fontWeight = FontWeight.ExtraLight
        )

    val Light: TextStyle
        @Composable get() = TextStyle(
            fontFamily = setFont(),
            fontWeight = FontWeight.Light
        )

    val Medium: TextStyle
        @Composable get() = TextStyle(
            fontFamily = setFont(),
            fontWeight = FontWeight.Medium
        )

    val Regular: TextStyle
        @Composable get() = TextStyle(
            fontFamily = setFont(),
            fontWeight = FontWeight.Normal
        )

    val SemiBold: TextStyle
        @Composable get() = TextStyle(
            fontFamily = setFont(),
            fontWeight = FontWeight.SemiBold
        )

    val Thin: TextStyle
        @Composable get() = TextStyle(
            fontFamily = setFont(),
            fontWeight = FontWeight.Thin
        )
}