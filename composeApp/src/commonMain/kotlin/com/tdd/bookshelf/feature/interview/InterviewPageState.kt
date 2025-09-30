package com.tdd.bookshelf.feature.interview

import com.tdd.bookshelf.core.ui.base.PageState
import com.tdd.bookshelf.domain.entity.response.interview.InterviewChatItem
import com.tdd.bookshelf.domain.entity.response.interview.InterviewConversationListModel

data class InterviewPageState (
    val interviewConversationModel: InterviewConversationListModel = InterviewConversationListModel(),
    val interviewChatList: List<InterviewChatItem> = emptyList()
): PageState