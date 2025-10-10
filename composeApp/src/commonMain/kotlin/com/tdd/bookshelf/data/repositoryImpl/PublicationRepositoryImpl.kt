package com.tdd.bookshelf.data.repositoryImpl

import com.tdd.bookshelf.data.dataSource.PublicationDataSource
import com.tdd.bookshelf.data.mapper.base.DefaultBooleanMapper
import com.tdd.bookshelf.domain.entity.request.publication.PostPublicationModel
import com.tdd.bookshelf.domain.repository.PublicationRepository
import kotlinx.coroutines.flow.Flow
import org.koin.core.annotation.Single

@Single(binds = [PublicationRepository::class])
class PublicationRepositoryImpl(
    private val publicationDataSource: PublicationDataSource,
) : PublicationRepository {

    override suspend fun postPublication(request: PostPublicationModel): Flow<Result<Boolean>> =
        DefaultBooleanMapper.responseToModel(apiCall = {
            publicationDataSource.postPublication(
                request.title,
                request.preCoverImage,
                request.titlePosition.value
            )
        })
}