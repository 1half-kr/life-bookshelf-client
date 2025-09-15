package com.tdd.bookshelf.app.di

import com.tdd.bookshelf.data.dataSource.AuthDataSource
import com.tdd.bookshelf.data.dataSource.dataSourceImpl.AuthDataSourceImpl
import org.koin.dsl.module

val dataSourceModule = module {
    single<AuthDataSource> { AuthDataSourceImpl(get()) }
}