package com.tdd.bookshelf.feature.home

import com.tdd.bookshelf.core.ui.base.BaseViewModel
import com.tdd.bookshelf.domain.entity.response.autobiography.ChapterItemModel
import com.tdd.bookshelf.domain.entity.response.autobiography.ChapterListModel
import com.tdd.bookshelf.domain.entity.response.autobiography.SubChapterItemModel
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class HomeViewModel : BaseViewModel<HomePageState>(
    HomePageState()
) {

    init {
        initSetChapterList()
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