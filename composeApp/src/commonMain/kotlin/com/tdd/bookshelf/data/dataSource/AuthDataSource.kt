package com.tdd.bookshelf.data.dataSource

import com.tdd.bookshelf.data.entity.request.auth.EmailLogInRequestDto
import com.tdd.bookshelf.data.entity.response.auth.EmailLogInResponseDto

interface AuthDataSource {
    suspend fun postEmailLogIn(request: EmailLogInRequestDto): EmailLogInResponseDto
}