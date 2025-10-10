package com.tdd.bookshelf.domain.repository

import com.tdd.bookshelf.domain.entity.request.publication.PostPublicationModel
import kotlinx.coroutines.flow.Flow

interface PublicationRepository {
    suspend fun postPublication(request: PostPublicationModel): Flow<Result<Boolean>>
}