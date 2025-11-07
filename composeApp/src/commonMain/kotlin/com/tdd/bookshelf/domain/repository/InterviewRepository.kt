package com.tdd.bookshelf.domain.repository

import com.tdd.bookshelf.domain.entity.response.interview.InterviewConversationListModel
import kotlinx.coroutines.flow.Flow

interface InterviewRepository {
    suspend fun getInterviewConversation(interviewId: Int): Flow<Result<InterviewConversationListModel>>
    suspend fun postInterviewRenewal(interviewId: Int): Flow<Result<Boolean>>
}