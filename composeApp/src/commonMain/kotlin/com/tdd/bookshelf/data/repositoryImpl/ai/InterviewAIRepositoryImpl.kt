package com.tdd.bookshelf.data.repositoryImpl.ai

import com.tdd.bookshelf.data.dataSource.ai.InterviewAIDataSource
import com.tdd.bookshelf.data.mapper.interview.GetInterviewConversationMapper
import com.tdd.bookshelf.data.mapper.interview.ai.CreateInterviewQuestionMapper
import com.tdd.bookshelf.data.mapper.interview.ai.CreateInterviewQuestionMapper.toDto
import com.tdd.bookshelf.domain.entity.request.interview.ai.InterviewQuestionsRequestModel
import com.tdd.bookshelf.domain.entity.response.interview.InterviewConversationListModel
import com.tdd.bookshelf.domain.entity.response.interview.ai.InterviewQuestionsAIResponseModel
import com.tdd.bookshelf.domain.repository.InterviewAIRepository
import kotlinx.coroutines.flow.Flow
import org.koin.core.annotation.Single

@Single(binds = [InterviewAIRepository::class])
class InterviewAIRepositoryImpl(
    private val interviewAIDataSource: InterviewAIDataSource,
) : InterviewAIRepository {

    override suspend fun postInterviewQuestions(body: InterviewQuestionsRequestModel): Flow<Result<InterviewQuestionsAIResponseModel>> =
        CreateInterviewQuestionMapper.responseToModel(apiCall = {
            interviewAIDataSource.postInterviewQuestions(
                body.toDto()
            )
        })

    override suspend fun getInterviewConversation(interviewId: Int): Flow<Result<InterviewConversationListModel>> =
        GetInterviewConversationMapper.responseToModel(apiCall = {
            interviewAIDataSource.getInterviewConversation(interviewId)
        })
}