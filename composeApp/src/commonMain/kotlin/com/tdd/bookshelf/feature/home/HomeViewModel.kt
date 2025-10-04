package com.tdd.bookshelf.feature.home

import androidx.lifecycle.viewModelScope
import co.touchlab.kermit.Logger.Companion.d
import com.tdd.bookshelf.core.ui.base.BaseViewModel
import com.tdd.bookshelf.domain.entity.response.autobiography.ChapterListModel
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
                chapterList = data
            )
        )
    }
}