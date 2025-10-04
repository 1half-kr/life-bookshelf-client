package com.tdd.bookshelf.domain.repository

import com.tdd.bookshelf.domain.entity.response.autobiography.AllAutobiographyListModel
import com.tdd.bookshelf.domain.entity.response.autobiography.AutobiographiesDetailModel
import com.tdd.bookshelf.domain.entity.response.autobiography.ChapterListModel
import kotlinx.coroutines.flow.Flow

interface AutobiographyRepository {
    suspend fun getAllAutobiographies(): Flow<Result<AllAutobiographyListModel>>
    suspend fun getAutobiographiesDetail(autobiographyId: Int): Flow<Result<AutobiographiesDetailModel>>
    suspend fun deleteAutobiography(autobiographyId: Int): Flow<Result<Boolean>>
    suspend fun getAutobiographyChapter(): Flow<Result<ChapterListModel>>
}