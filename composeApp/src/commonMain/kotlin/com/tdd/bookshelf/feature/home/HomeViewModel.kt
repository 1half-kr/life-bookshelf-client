package com.tdd.bookshelf.feature.home

import androidx.lifecycle.viewModelScope
import co.touchlab.kermit.Logger.Companion.d
import com.tdd.bookshelf.core.ui.base.BaseViewModel
import com.tdd.bookshelf.domain.entity.response.autobiography.AllAutobiographyListModel
import com.tdd.bookshelf.domain.entity.response.autobiography.ChapterItemModel
import com.tdd.bookshelf.domain.entity.response.autobiography.ChapterListModel
import com.tdd.bookshelf.domain.entity.response.autobiography.SubChapterItemModel
import com.tdd.bookshelf.domain.usecase.autobiograph.GetAllAutobiographyUseCase
import com.tdd.bookshelf.domain.usecase.autobiograph.GetAutobiographiesChapterListUseCase
import com.tdd.bookshelf.domain.usecase.member.GetMemberInfoUseCase
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class HomeViewModel(
    private val getAutobiographiesChapterListUseCase: GetAutobiographiesChapterListUseCase,
    private val getAllAutobiographyUseCase: GetAllAutobiographyUseCase,
    private val getMemberInfoUseCase: GetMemberInfoUseCase
) : BaseViewModel<HomePageState>(
    HomePageState()
) {

    init {
        initSetChapterList()
        initSetAllAutobiography()
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

    private fun setCurrentChapterItem(
        currentChapterId: Int,
        chapters: List<ChapterItemModel>,
    ): SubChapterItemModel {
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

    private fun initSetAllAutobiography() {
        viewModelScope.launch {
            getAllAutobiographyUseCase(Unit).collect {
                resultResponse(
                    it,
                    ::onSuccessAllAutobiography
                )
            }
        }
    }

    private fun onSuccessAllAutobiography(data: AllAutobiographyListModel) {
        updateState(
            uiState.value.copy(
                allAutobiography = data,
                allAutobiographyList = data.results
            )
        )
    }

    fun setInterviewId(): Int {
        val currentChapterId = uiState.value.currentChapterId
        val interviewId =
            uiState.value.allAutobiographyList.firstOrNull { it.chapterId == currentChapterId }?.interviewId
                ?: 0

        return interviewId
    }

    fun setAutobiographyId(chapterId: Int): Int {
        var autobiographyId = uiState.value.allAutobiographyList.firstOrNull { it.chapterId == chapterId }?.autobiographyId
            ?: 0

        if (autobiographyId == 0) {
            createAutobiography()
            initSetAllAutobiography()
            autobiographyId = uiState.value.allAutobiographyList.firstOrNull { it.chapterId == chapterId }?.autobiographyId ?: 0
            return autobiographyId
        } else return autobiographyId
    }

    private fun createAutobiography() {
        generateInterviewQuestions()
    }

    private fun generateInterviewQuestions() {
        //
    }
}