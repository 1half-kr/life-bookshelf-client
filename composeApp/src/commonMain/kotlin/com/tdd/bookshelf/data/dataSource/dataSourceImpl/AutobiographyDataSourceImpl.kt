package com.tdd.bookshelf.data.dataSource.dataSourceImpl

import com.tdd.bookshelf.data.dataSource.AutobiographyDataSource
import com.tdd.bookshelf.data.service.AutobiographyService
import io.ktor.client.statement.HttpResponse
import org.koin.core.annotation.Single

@Single(binds = [AutobiographyDataSource::class])
class AutobiographyDataSourceImpl(
    private val autobiographyService: AutobiographyService,
) : AutobiographyDataSource {

    override suspend fun getAllAutobiographies(): HttpResponse =
        autobiographyService.getAllAutobiographies()

    override suspend fun getAutobiographiesDetail(autobiographyId: Int): HttpResponse =
        autobiographyService.getAutobiographiesDetail(autobiographyId)

    override suspend fun deleteAutobiography(autobiographyId: Int): HttpResponse =
        autobiographyService.deleteAutobiography(autobiographyId)

    override suspend fun getAutobiographyChapter(): HttpResponse =
        autobiographyService.getAutobiographiesChapter()

    override suspend fun postUpdateCurrentChapter(): HttpResponse =
        autobiographyService.updateCurrentChapter()
}