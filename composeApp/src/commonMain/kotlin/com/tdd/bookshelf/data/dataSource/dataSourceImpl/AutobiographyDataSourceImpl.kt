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
}