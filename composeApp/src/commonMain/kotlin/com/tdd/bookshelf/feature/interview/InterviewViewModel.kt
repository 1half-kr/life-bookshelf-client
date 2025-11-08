package com.tdd.bookshelf.feature.interview

import androidx.lifecycle.viewModelScope
import co.touchlab.kermit.Logger.Companion.d
import com.tdd.bookshelf.core.ui.base.BaseViewModel
import com.tdd.bookshelf.domain.entity.enums.ChatType
import com.tdd.bookshelf.domain.entity.response.interview.InterviewChatItem
import com.tdd.bookshelf.domain.entity.response.interview.InterviewConversationListModel
import com.tdd.bookshelf.domain.usecase.interview.GetInterviewConversationUseCase
import com.tdd.bookshelf.feature.interview.type.ConversationType
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class InterviewViewModel(
    private val getInterviewConversationUseCase: GetInterviewConversationUseCase
) : BaseViewModel<InterviewPageState>(
    InterviewPageState()
) {

    fun setInterviewId(interviewId: Int) {
        d("[test] interviewViewModel -> $interviewId")
        updateState(
            uiState.value.copy(
                interviewId = interviewId
            )
        )

        initSetInterviewList(interviewId)
    }

    private fun initSetInterviewList(interviewId: Int) {
        viewModelScope.launch {
            getInterviewConversationUseCase(interviewId).collect {
                resultResponse(it, ::onSuccessSetInterviewConversationList)
            }
        }
    }

    private fun onSuccessSetInterviewConversationList(data: InterviewConversationListModel) {
        d("[test] interviewViewModel -> ${data.results}")
        updateState(
            uiState.value.copy(
                interviewConversationModel = data,
                interviewChatList = data.results
            )
        )
    }

    fun beginInterview() {
        updateState(
            uiState.value.copy(
                interviewProgressType = ConversationType.ING
            )
        )
    }

    fun setInterviewAnswer(chat: String) {
        val originalInterviews = uiState.value.interviewChatList
        val newAnswer = InterviewChatItem(content = chat, chatType = ChatType.HUMAN)

        updateState(
            uiState.value.copy(
                interviewChatList = originalInterviews + newAnswer,
                interviewProgressType = ConversationType.BEFORE
            )
        )
    }
}