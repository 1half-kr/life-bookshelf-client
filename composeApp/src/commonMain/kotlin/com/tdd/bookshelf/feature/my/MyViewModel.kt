package com.tdd.bookshelf.feature.my

import androidx.lifecycle.viewModelScope
import com.tdd.bookshelf.core.ui.base.BaseViewModel
import com.tdd.bookshelf.domain.entity.response.member.MemberInfoModel
import com.tdd.bookshelf.domain.entity.response.publication.PublishMyListItemModel
import com.tdd.bookshelf.domain.usecase.member.GetMemberInfoUseCase
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class MyViewModel(
    private val getMemberInfoUseCase: GetMemberInfoUseCase
) : BaseViewModel<MyPageState>(
    MyPageState()
) {
    init {
        initSetPublishBookList()
        initSetMemberInfo()
    }

    private fun initSetPublishBookList() {
        val bookList = listOf(
            PublishMyListItemModel(0, 0, "외쳐라 최강기아", "", "", "", 0, ""),
            PublishMyListItemModel(0, 0, "열광하라 타이거즈", "", "", "", 0, ""),
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

    private fun initSetMemberInfo() {
        viewModelScope.launch {
            getMemberInfoUseCase(Unit).collect { resultResponse(it, ::onSuccessGetMemberInfo) }
        }
    }

    private fun onSuccessGetMemberInfo(data: MemberInfoModel) {
        updateState(
            uiState.value.copy(
                memberInfo = data
            )
        )
    }
}