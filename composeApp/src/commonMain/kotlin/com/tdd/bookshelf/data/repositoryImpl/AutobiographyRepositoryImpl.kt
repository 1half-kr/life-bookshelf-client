package com.tdd.bookshelf.data.repositoryImpl

import com.tdd.bookshelf.data.dataSource.AutobiographyDataSource
import com.tdd.bookshelf.data.mapper.autobiograph.AllAutobiographyMapper
import com.tdd.bookshelf.domain.entity.response.autobiography.AllAutobiographyListModel
import com.tdd.bookshelf.domain.repository.AutobiographyRepository
import kotlinx.coroutines.flow.Flow
import org.koin.core.annotation.Single

@Single(binds = [AutobiographyRepository::class])
class AutobiographyRepositoryImpl(
    private val autobiographyDataSource: AutobiographyDataSource,
) : AutobiographyRepository {
    override suspend fun getAllAutobiographies(): Flow<Result<AllAutobiographyListModel>> =
        AllAutobiographyMapper.responseToModel(apiCall = { autobiographyDataSource.getAllAutobiographies() })
}