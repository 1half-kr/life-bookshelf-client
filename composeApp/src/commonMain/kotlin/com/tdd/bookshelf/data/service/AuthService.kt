package com.tdd.bookshelf.data.service

import com.tdd.bookshelf.data.base.EndPoints
import com.tdd.bookshelf.data.entity.request.auth.EmailLogInRequestDto
import com.tdd.bookshelf.data.entity.response.auth.EmailLogInResponseDto
import de.jensklingenberg.ktorfit.http.Body
import de.jensklingenberg.ktorfit.http.POST

interface AuthService {

    @POST(EndPoints.Auth.EMAILLOGIN)
    suspend fun postEmailLogIn(
        @Body body: EmailLogInRequestDto,
    ): EmailLogInResponseDto
}