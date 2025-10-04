package com.tdd.bookshelf.feature.home

import androidx.lifecycle.viewModelScope
import co.touchlab.kermit.Logger.Companion.d
import com.tdd.bookshelf.core.ui.base.BaseViewModel
import com.tdd.bookshelf.domain.entity.response.autobiography.ChapterItemModel
import com.tdd.bookshelf.domain.entity.response.autobiography.ChapterListModel
import com.tdd.bookshelf.domain.entity.response.autobiography.SubChapterItemModel
import com.tdd.bookshelf.domain.usecase.autobiograph.GetAutobiographiesChapterListUseCase
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class HomeViewModel(
    private val getAutobiographiesChapterListUseCase: GetAutobiographiesChapterListUseCase,
) : BaseViewModel<HomePageState>(
    HomePageState()
) {

    init {
        initSetChapterList()
    }

    private fun initSetChapterList() {
        viewModelScope.launch {
            getAutobiographiesChapterListUseCase(Unit).collect {
                resultResponse(
                    it,
                    ::onSuccessGetChapterList
                )
            }
        }
    }

    private fun onSuccessGetChapterList(data: ChapterListModel) {
        d("[ktor] homeViewmodel -> $data")
        updateState(
            uiState.value.copy(
                chapterList = data.results,
                currentChapterId = data.currentChapterId,
                currentChapter = setCurrentChapterItem(data.currentChapterId, data.results)
            )
        )
    }

    private fun setCurrentChapterItem(currentChapterId: Int, chapters: List<ChapterItemModel>): SubChapterItemModel {
        var currentChapter: SubChapterItemModel

        chapters.firstOrNull { it.chapterId == currentChapterId }?.let { chapterItem ->
            currentChapter = SubChapterItemModel(
                chapterItem.chapterId,
                chapterItem.chapterNumber,
                chapterItem.chapterName,
                chapterItem.chapterDescription,
                chapterItem.chapterCreatedAt
            )

            return currentChapter
        }

        for (chapter in chapters) {
            val subChapter = chapter.subChapters.firstOrNull { it.chapterId == currentChapterId }
            if (subChapter != null) return subChapter
        }

        return SubChapterItemModel()
    }
}