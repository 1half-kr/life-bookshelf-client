package com.tdd.bookshelf.data.dataSource.dataSourceImpl

import com.tdd.bookshelf.data.dataSource.InterviewDataSource
import com.tdd.bookshelf.data.service.InterviewService
import io.ktor.client.statement.HttpResponse
import org.koin.core.annotation.Single

@Single(binds = [InterviewDataSource::class])
class InterviewDataSourceImpl(
    private val interviewService: InterviewService
): InterviewDataSource {
    override suspend fun getInterviewConversation(interviewId: Int): HttpResponse =
        interviewService.getInterviewConversation(interviewId)

    override suspend fun postInterviewRenewal(interviewId: Int): HttpResponse =
        interviewService.postInterviewRenewal(interviewId)
}