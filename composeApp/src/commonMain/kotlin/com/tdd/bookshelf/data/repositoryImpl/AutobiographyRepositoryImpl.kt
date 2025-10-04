package com.tdd.bookshelf.data.repositoryImpl

import com.tdd.bookshelf.data.dataSource.AutobiographyDataSource
import com.tdd.bookshelf.data.mapper.autobiograph.AllAutobiographyMapper
import com.tdd.bookshelf.data.mapper.autobiograph.AutobiographiesDetailMapper
import com.tdd.bookshelf.data.mapper.autobiograph.AutobiographyChapterMapper
import com.tdd.bookshelf.data.mapper.base.DefaultBooleanMapper
import com.tdd.bookshelf.domain.entity.response.autobiography.AllAutobiographyListModel
import com.tdd.bookshelf.domain.entity.response.autobiography.AutobiographiesDetailModel
import com.tdd.bookshelf.domain.entity.response.autobiography.ChapterListModel
import com.tdd.bookshelf.domain.repository.AutobiographyRepository
import kotlinx.coroutines.flow.Flow
import org.koin.core.annotation.Single

@Single(binds = [AutobiographyRepository::class])
class AutobiographyRepositoryImpl(
    private val autobiographyDataSource: AutobiographyDataSource,
) : AutobiographyRepository {
    override suspend fun getAllAutobiographies(): Flow<Result<AllAutobiographyListModel>> =
        AllAutobiographyMapper.responseToModel(apiCall = { autobiographyDataSource.getAllAutobiographies() })

    override suspend fun getAutobiographiesDetail(autobiographyId: Int): Flow<Result<AutobiographiesDetailModel>> =
        AutobiographiesDetailMapper.responseToModel(apiCall = {
            autobiographyDataSource.getAutobiographiesDetail(
                autobiographyId
            )
        })

    override suspend fun deleteAutobiography(autobiographyId: Int): Flow<Result<Boolean>> =
        DefaultBooleanMapper.responseToModel(apiCall = {
            autobiographyDataSource.deleteAutobiography(
                autobiographyId
            )
        })

    override suspend fun getAutobiographyChapter(): Flow<Result<ChapterListModel>> =
        AutobiographyChapterMapper.responseToModel(apiCall = { autobiographyDataSource.getAutobiographyChapter() })
}