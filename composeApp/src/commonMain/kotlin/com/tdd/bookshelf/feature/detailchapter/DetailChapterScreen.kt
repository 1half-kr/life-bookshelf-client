package com.tdd.bookshelf.feature.detailchapter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.tdd.bookshelf.core.designsystem.White0
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
internal fun DetailChapterScreen() {
    val viewModel: DetailChapterViewModel = koinViewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    DetailChapterContent()
}

@Composable
private fun DetailChapterContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White0)
    ) {
        //
    }
}

@Preview
@Composable
fun PreviewDetailChapter() {
    DetailChapterContent()
}