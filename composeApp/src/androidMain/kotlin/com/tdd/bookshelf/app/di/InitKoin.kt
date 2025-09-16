package com.tdd.bookshelf.app.di

import android.app.Application
import com.tdd.bookshelf.feature.home.HomeModule
import com.tdd.bookshelf.feature.login.LogInModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module

fun Application.initKoin(): KoinApplication =
    startKoin {
        androidContext(this@initKoin)
        androidLogger()
        modules(
            commonModule,
            KtorModule.module,
            ServiceModule().module,
            useCaseModule,
            dataSourceModule,
            repositoryModule,

            LogInModule().module,
            HomeModule().module
        )
    }