package com.tdd.bookshelf.data.dataSource.dataSourceImpl

import com.tdd.bookshelf.data.dataSource.AuthDataSource
import com.tdd.bookshelf.data.entity.request.auth.EmailLogInRequestDto
import com.tdd.bookshelf.data.entity.response.auth.EmailLogInResponseDto
import com.tdd.bookshelf.data.service.AuthService
import org.koin.core.annotation.Single

@Single(binds = [AuthDataSource::class])
class AuthDataSourceImpl(
    private val authService: AuthService,
) : AuthDataSource {

    override suspend fun postEmailLogIn(request: EmailLogInRequestDto): EmailLogInResponseDto =
        authService.postEmailLogIn(request)
}