package com.tdd.bookshelf.app.di

import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(
            viewModelModule,
            ktorModule,
            serviceModule,
            useCaseModule,
            dataSourceModule,
            repositoryModule,
        )
    }
}