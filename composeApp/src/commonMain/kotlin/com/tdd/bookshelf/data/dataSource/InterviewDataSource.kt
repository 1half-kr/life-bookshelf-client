package com.tdd.bookshelf.data.dataSource

import io.ktor.client.statement.HttpResponse

interface InterviewDataSource {
    suspend fun getInterviewConversation(interviewId: Int): HttpResponse
    suspend fun postInterviewRenewal(interviewId: Int): HttpResponse
}