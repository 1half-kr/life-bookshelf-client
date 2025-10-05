package com.tdd.bookshelf.data.dataSource

import io.ktor.client.statement.HttpResponse

interface MemberDataSource {
    suspend fun getMemberInfo(): HttpResponse
}