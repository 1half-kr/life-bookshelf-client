package com.tdd.bookshelf.data.mapper.auth

import com.tdd.bookshelf.data.base.BaseMapper
import com.tdd.bookshelf.data.entity.request.auth.EmailLogInRequestDto
import com.tdd.bookshelf.data.entity.response.auth.EmailLogInResponseDto
import com.tdd.bookshelf.domain.entity.request.auth.EmailLogInRequestModel
import com.tdd.bookshelf.domain.entity.response.auth.AccessTokenModel
import kotlinx.coroutines.flow.Flow

object EmailLogInMapper : BaseMapper() {
    fun EmailLogInRequestModel.toDto() = EmailLogInRequestDto(
        email = email,
        password = password,
        deviceToken = deviceToken
    )

    fun responseToModel(apiCall: suspend () -> EmailLogInResponseDto): Flow<Result<AccessTokenModel>> {
        return baseMapper(
            apiCall = { apiCall() },
            responseToModel = { response ->
                response?.let { data ->
                    AccessTokenModel(
                        accessToken = data.accessToken
                    )
                } ?: AccessTokenModel()
            }
        )
    }
}