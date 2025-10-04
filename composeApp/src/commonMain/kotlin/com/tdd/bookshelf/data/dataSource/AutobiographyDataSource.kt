package com.tdd.bookshelf.data.dataSource

import io.ktor.client.statement.HttpResponse

interface AutobiographyDataSource {
    suspend fun getAllAutobiographies(): HttpResponse
    suspend fun getAutobiographiesDetail(autobiographyId: Int): HttpResponse
    suspend fun deleteAutobiography(autobiographyId: Int): HttpResponse
    suspend fun getAutobiographyChapter(): HttpResponse
    suspend fun postUpdateCurrentChapter(): HttpResponse
}