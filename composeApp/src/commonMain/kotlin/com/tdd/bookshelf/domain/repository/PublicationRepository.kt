package com.tdd.bookshelf.domain.repository

import com.tdd.bookshelf.domain.entity.request.default.GetQueryDefaultModel
import com.tdd.bookshelf.domain.entity.request.publication.PostPublicationModel
import com.tdd.bookshelf.domain.entity.response.publication.PublishMyListModel
import kotlinx.coroutines.flow.Flow

interface PublicationRepository {
    suspend fun postPublication(request: PostPublicationModel): Flow<Result<Boolean>>
    suspend fun getMyPublication(request: GetQueryDefaultModel): Flow<Result<PublishMyListModel>>
}