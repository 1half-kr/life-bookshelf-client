package com.tdd.bookshelf.data.service

import com.tdd.bookshelf.data.base.EndPoints
import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.POST
import de.jensklingenberg.ktorfit.http.Path
import io.ktor.client.statement.HttpResponse

interface InterviewService {
    @GET(EndPoints.Interview.INTERVIEWCONVERSATION)
    suspend fun getInterviewConversation(
        @Path("interviewId") interviewId: Int
    ): HttpResponse

    @POST(EndPoints.Interview.INTERVIEWRENEWAL)
    suspend fun postInterviewRenewal(
        @Path("interviewId") interviewId: Int
    ): HttpResponse
}