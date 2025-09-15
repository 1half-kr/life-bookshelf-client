package com.tdd.bookshelf.data.dataSource

import io.ktor.client.statement.HttpResponse

interface AuthDataSource {
    suspend fun postEmailLogIn(
        email: String,
        password: String,
        deviceToken: String,
    ): HttpResponse
}