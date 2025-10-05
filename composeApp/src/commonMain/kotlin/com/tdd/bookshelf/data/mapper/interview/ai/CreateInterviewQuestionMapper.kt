package com.tdd.bookshelf.data.mapper.interview.ai

import com.tdd.bookshelf.data.base.BaseMapper
import com.tdd.bookshelf.data.entity.request.interview.ai.InterviewQuestionsRequestDto
import com.tdd.bookshelf.data.entity.response.interview.ai.InterviewQuestionsResponseDto
import com.tdd.bookshelf.domain.entity.request.interview.ai.InterviewQuestionsRequestModel
import com.tdd.bookshelf.domain.entity.response.interview.ai.InterviewQuestionsAIResponseModel
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.flow.Flow

object CreateInterviewQuestionMapper : BaseMapper() {

    fun InterviewQuestionsRequestModel.toDto() = InterviewQuestionsRequestDto(
        userInfo = InterviewQuestionsRequestDto.UserInfo(
            userInfo.name,
            userInfo.bornedAt,
            userInfo.gender,
            userInfo.hasChildren,
            userInfo.occupation ?: "",
            userInfo.educationLevel ?: "",
            userInfo.maritalStatus ?: ""
        ),
        chapterInfo = InterviewQuestionsRequestDto.ChapterInfo(
            chapterInfo.title,
            chapterInfo.description
        ),
        subChapterInfo = InterviewQuestionsRequestDto.ChapterInfo(
            chapterInfo.title,
            chapterInfo.description
        )
    )

    fun responseToModel(apiCall: suspend () -> HttpResponse): Flow<Result<InterviewQuestionsAIResponseModel>> {
        return baseMapper(
            apiCall = { apiCall() },
            successDeserializer = InterviewQuestionsResponseDto.serializer(),
            responseToModel = { response ->
                response?.let { data ->
                    InterviewQuestionsAIResponseModel(
                        interviewQuestions = data.interviewQuestions
                    )
                } ?: InterviewQuestionsAIResponseModel()
            }
        )
    }
}