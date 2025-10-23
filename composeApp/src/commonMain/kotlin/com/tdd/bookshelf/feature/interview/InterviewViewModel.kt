package com.tdd.bookshelf.feature.interview

import co.touchlab.kermit.Logger.Companion.d
import com.tdd.bookshelf.core.ui.base.BaseViewModel
import com.tdd.bookshelf.domain.entity.enums.ChatType
import com.tdd.bookshelf.domain.entity.response.interview.InterviewChatItem
import com.tdd.bookshelf.domain.entity.response.interview.InterviewConversationListModel
import com.tdd.bookshelf.feature.interview.type.ConversationType
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class InterviewViewModel : BaseViewModel<InterviewPageState>(
    InterviewPageState()
) {

    init {
        initSetInterviewList()
    }

    private fun initSetInterviewList() {
        val interviews = InterviewConversationListModel(
            currentPage = 0,
            totalElements = 0,
            totalPages = 0,
            hasNextPage = false,
            hasPreviousPage = false,
            results = listOf(
                InterviewChatItem(
                    content = "지금의 본인을 만든 가장 기억에 남는 사건 하나를 말해줘",
                    chatType = ChatType.BOT
                ),
            )
        )

        updateState(
            uiState.value.copy(
                interviewChatList = interviews.results
            )
        )
    }

    fun setInterviewId(interviewId: Int) {
        d("[test] interviewViewModel -> $interviewId")
        updateState(
            uiState.value.copy(
                interviewId = interviewId
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