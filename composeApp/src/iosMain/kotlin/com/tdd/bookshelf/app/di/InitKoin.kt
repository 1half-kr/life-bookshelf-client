package com.tdd.bookshelf.app.di

import org.koin.core.context.startKoin
import org.koin.ksp.generated.module

fun initKoin() {
    startKoin {
        modules(
            iosDataStoreModule,
            dataStoreModule,

            tokenModule,
            KtorModule.module,
            NoAuthModule.module,

            ServiceModule().module,
            dataSourceModule,
            repositoryModule,
            useCaseModule,
            viewModelModule,
        )
    }
}