package com.tdd.bookshelf.feature.home

import androidx.lifecycle.viewModelScope
import co.touchlab.kermit.Logger.Companion.d
import com.tdd.bookshelf.core.ui.base.BaseViewModel
import com.tdd.bookshelf.domain.entity.response.autobiography.AllAutobiographyListModel
import com.tdd.bookshelf.domain.entity.response.autobiography.ChapterItemModel
import com.tdd.bookshelf.domain.entity.response.autobiography.ChapterListModel
import com.tdd.bookshelf.domain.entity.response.autobiography.SubChapterItemModel
import com.tdd.bookshelf.domain.usecase.autobiograph.GetAllAutobiographyUseCase
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class HomeViewModel(
    private val getAllAutobiographyUseCase: GetAllAutobiographyUseCase
) : BaseViewModel<HomePageState>(
    HomePageState()
) {

    init {
        initSetChapterList()

        initTestAutobiography()
    }

    private fun initTestAutobiography() {
        viewModelScope.launch {
            getAllAutobiographyUseCase(Unit).collect { resultResponse(it, ::onSuccess) }
        }
    }

    private fun onSuccess(data: AllAutobiographyListModel) {
        d("[테스트] -> $data")
    }

    private fun initSetChapterList() {
        val mockChapterList = ChapterListModel(
            currentChapterId = 2,
            results = listOf(
                ChapterItemModel(
                    0, "1", "Chapter 1: Early Life", "test", "",
                    subChapters = listOf(
                        SubChapterItemModel(1, "1.1", "Subchapter 1: Childhood", "test"),
                        SubChapterItemModel(2, "1.2", "Subchapter 1: Childhood", "test")
                    )
                ),
                ChapterItemModel(
                    3, "2", "Chapter 2: Early Life", "test", "",
                    subChapters = listOf(
                        SubChapterItemModel(4, "2.1", "Subchapter 2: Childhood", "test"),
                        SubChapterItemModel(5, "2.2", "Subchapter 2: Childhood", "test"),
                        SubChapterItemModel(6, "2.3", "Subchapter 2: Childhood", "test")
                    )
                ),
                ChapterItemModel(
                    7, "3", "Chapter 3: Early Life", "test", "",
                    subChapters = listOf(
                        SubChapterItemModel(8, "3.1", "Subchapter 3: Childhood", "test"),
                        SubChapterItemModel(9, "3.2", "Subchapter 3: Childhood", "test")
                    )
                ),
            )
        )

        updateState(
            uiState.value.copy(
                chapterList = mockChapterList
            )
        )
    }
}