package com.tdd.bookshelf.data.dataSource

import com.tdd.bookshelf.data.entity.response.auth.EmailLogInResponseDto

interface AuthDataSource {
    suspend fun postEmailLogIn(
        email: String,
        password: String,
        deviceToken: String,
    ): EmailLogInResponseDto
}