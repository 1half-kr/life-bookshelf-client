package com.tdd.bookshelf.data.service

import com.tdd.bookshelf.data.base.EndPoints
import com.tdd.bookshelf.data.entity.response.auth.EmailLogInResponseDto
import de.jensklingenberg.ktorfit.http.Multipart
import de.jensklingenberg.ktorfit.http.POST
import de.jensklingenberg.ktorfit.http.Part

interface AuthService {

    @Multipart
    @POST(EndPoints.Auth.EMAILLOGIN)
    suspend fun postEmailLogIn(
        @Part("email") email: String,
        @Part("password") password: String,
        @Part("deviceToken") deviceToken: String = "",
    ): EmailLogInResponseDto
}