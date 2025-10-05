package com.tdd.bookshelf.data.service.ai

import com.tdd.bookshelf.data.base.EndPoints
import com.tdd.bookshelf.data.entity.request.interview.ai.InterviewQuestionsRequestDto
import de.jensklingenberg.ktorfit.http.Body
import de.jensklingenberg.ktorfit.http.POST
import io.ktor.client.statement.HttpResponse

interface InterviewAIService {
    @POST(EndPoints.Interview.INTERVIEWQUESTION)
    suspend fun postCreateInterviewQuestion(
        @Body body: InterviewQuestionsRequestDto
    ): HttpResponse
}