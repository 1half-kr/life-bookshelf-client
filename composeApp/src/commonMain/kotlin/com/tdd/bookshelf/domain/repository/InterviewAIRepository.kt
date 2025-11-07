package com.tdd.bookshelf.domain.repository

import com.tdd.bookshelf.domain.entity.request.interview.ai.InterviewQuestionsRequestModel
import com.tdd.bookshelf.domain.entity.response.interview.InterviewConversationListModel
import com.tdd.bookshelf.domain.entity.response.interview.ai.InterviewQuestionsAIResponseModel
import kotlinx.coroutines.flow.Flow

interface InterviewAIRepository {
    suspend fun postInterviewQuestions(body: InterviewQuestionsRequestModel): Flow<Result<InterviewQuestionsAIResponseModel>>
    suspend fun getInterviewConversation(interviewId: Int): Flow<Result<InterviewConversationListModel>>
    suspend fun postInterviewRenewal(interviewId: Int): Flow<Result<Boolean>>
}