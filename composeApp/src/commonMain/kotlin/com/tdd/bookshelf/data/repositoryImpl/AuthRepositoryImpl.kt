package com.tdd.bookshelf.data.repositoryImpl

import com.tdd.bookshelf.data.dataSource.AuthDataSource
import com.tdd.bookshelf.data.mapper.auth.EmailLogInMapper
import com.tdd.bookshelf.data.mapper.auth.EmailLogInMapper.toDto
import com.tdd.bookshelf.domain.entity.request.auth.EmailLogInRequestModel
import com.tdd.bookshelf.domain.entity.response.auth.AccessTokenModel
import com.tdd.bookshelf.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import org.koin.core.annotation.Single

@Single(binds = [AuthRepository::class])
class AuthRepositoryImpl(
    private val authDataSource: AuthDataSource
): AuthRepository {
    override suspend fun postEmailLogIn(request: EmailLogInRequestModel): Flow<Result<AccessTokenModel>> =
        EmailLogInMapper.responseToModel(apiCall = { authDataSource.postEmailLogIn(request.toDto() )})
}