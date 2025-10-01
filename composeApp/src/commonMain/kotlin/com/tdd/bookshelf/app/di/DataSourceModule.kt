package com.tdd.bookshelf.app.di

import com.tdd.bookshelf.data.dataSource.AuthDataSource
import com.tdd.bookshelf.data.dataSource.AutobiographyDataSource
import com.tdd.bookshelf.data.dataSource.dataSourceImpl.AuthDataSourceImpl
import com.tdd.bookshelf.data.dataSource.dataSourceImpl.AutobiographyDataSourceImpl
import org.koin.dsl.module

val dataSourceModule = module {
    single<AuthDataSource> { AuthDataSourceImpl(get()) }
    single<AutobiographyDataSource> { AutobiographyDataSourceImpl(get()) }
}