package com.tdd.bookshelf.domain.repository

import com.tdd.bookshelf.domain.entity.response.autobiography.AllAutobiographyListModel
import kotlinx.coroutines.flow.Flow

interface AutobiographyRepository {
    suspend fun getAllAutobiographies(): Flow<Result<AllAutobiographyListModel>>
}