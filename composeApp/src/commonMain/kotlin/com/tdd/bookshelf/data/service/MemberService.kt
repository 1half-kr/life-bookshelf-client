package com.tdd.bookshelf.data.service

import com.tdd.bookshelf.data.base.EndPoints
import de.jensklingenberg.ktorfit.http.GET
import io.ktor.client.statement.HttpResponse

interface MemberService {

    @GET(EndPoints.Member.MEMBER)
    suspend fun getMemberInfo(): HttpResponse
}