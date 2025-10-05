package com.tdd.bookshelf.feature.interview

import co.touchlab.kermit.Logger.Companion.d
import com.tdd.bookshelf.core.ui.base.BaseViewModel
import com.tdd.bookshelf.domain.entity.enums.ChatType
import com.tdd.bookshelf.domain.entity.response.interview.InterviewChatItem
import com.tdd.bookshelf.domain.entity.response.interview.InterviewConversationListModel
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
                    content = "안녕하세요 안녕하세요 안녕하세요 안녕하세요 안녕하세요",
                    chatType = ChatType.BOT
                ),
                InterviewChatItem(
                    content = "나는 사람 나는 사람 나는 사람",
                    chatType = ChatType.HUMAN
                ),
                InterviewChatItem(
                    content = "아아아아아아",
                    chatType = ChatType.HUMAN
                )
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
}