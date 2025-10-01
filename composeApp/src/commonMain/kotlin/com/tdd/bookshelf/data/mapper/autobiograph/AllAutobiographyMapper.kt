package com.tdd.bookshelf.data.mapper.autobiograph

import com.tdd.bookshelf.data.base.BaseMapper
import com.tdd.bookshelf.data.entity.response.autobiography.AllAutobiographyResponseDto
import com.tdd.bookshelf.domain.entity.response.autobiography.AllAutobiographyItemModel
import com.tdd.bookshelf.domain.entity.response.autobiography.AllAutobiographyListModel
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.flow.Flow

object AllAutobiographyMapper : BaseMapper() {

    fun responseToModel(apiCall: suspend () -> HttpResponse): Flow<Result<AllAutobiographyListModel>> {
        return baseMapper(
            apiCall = { apiCall() },
            successDeserializer = AllAutobiographyResponseDto.serializer(),
            responseToModel = { response ->
                response?.let { data ->
                    AllAutobiographyListModel(
                        currentPage = data.currentPage,
                        totalPages = data.totalPages,
                        totalElements = data.totalElements,
                        isLast = data.isLast,
                        results = data.results.map { item ->
                            AllAutobiographyItemModel(
                                chapterId = 0,
                                title = "",
                                contentPreview = "",
                                coverImageUrl = "",
                                createdAt = "",
                                updatedAt = ""
                            )
                        }
                    )
                } ?: AllAutobiographyListModel()
            }
        )
    }
}