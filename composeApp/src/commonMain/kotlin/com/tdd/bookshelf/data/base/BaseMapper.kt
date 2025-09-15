package com.tdd.bookshelf.data.base

import com.tdd.bookshelf.data.entity.response.api.ApiError
import com.tdd.bookshelf.data.entity.response.api.ApiException
import io.ktor.client.plugins.ResponseException
import io.ktor.client.statement.bodyAsText
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.json.Json

abstract class BaseMapper {
    private val json = Json { ignoreUnknownKeys = true }

    fun <DTO, MODEL> baseMapper(
        apiCall: suspend () -> DTO?,
        responseToModel: (DTO?) -> MODEL,
    ): Flow<Result<MODEL>> = flow {
        val response = apiCall()
        val defaultModel = responseToModel(null)

        try {
            val apiResponse: DTO? = response
            val data = responseToModel(apiResponse) ?: defaultModel

            emit(Result.success(data))
        } catch (e: ResponseException) {
            val code = e.response.status.value
            val text = e.response.bodyAsText()
            val msg = runCatching { json.decodeFromString(ApiError.serializer(), text).message }
                .getOrNull() ?: "HTTP $code"
            emit(Result.failure(ApiException(code, msg)))
        } catch (t: Throwable) {
            emit(Result.failure(t))
        }
    }
}