package com.tdd.bookshelf.feature.my

import com.tdd.bookshelf.core.ui.base.BaseViewModel
import com.tdd.bookshelf.domain.entity.response.publication.PublishBookListItemModel
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class MyViewModel : BaseViewModel<MyPageState>(
    MyPageState()
) {
    init {
        initSetPublishBookList()
    }

    private fun initSetPublishBookList() {
        val bookList = listOf(
            PublishBookListItemModel(0, 0, "외쳐라 최강기아", "", "", "", 0, ""),
            PublishBookListItemModel(0, 0, "열광하라 타이거즈", "", "", "", 0, ""),
        )

        updateState(
            uiState.value.copy(
                publishBookList = bookList
            )
        )
    }

    fun changeAlarmActivatedStatus() {
        updateState(
            uiState.value.copy(
                isAlarmActivated = !uiState.value.isAlarmActivated
            )
        )
    }
}