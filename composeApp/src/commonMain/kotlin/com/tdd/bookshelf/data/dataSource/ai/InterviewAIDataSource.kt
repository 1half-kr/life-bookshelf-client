package com.tdd.bookshelf.data.dataSource.ai

import com.tdd.bookshelf.data.entity.request.interview.ai.InterviewQuestionsRequestDto
import io.ktor.client.statement.HttpResponse

interface InterviewAIDataSource {
    suspend fun postInterviewQuestions(body: InterviewQuestionsRequestDto): HttpResponse
    suspend fun getInterviewConversation(interviewId: Int): HttpResponse
    suspend fun postInterviewRenewal(interviewId: Int): HttpResponse
}