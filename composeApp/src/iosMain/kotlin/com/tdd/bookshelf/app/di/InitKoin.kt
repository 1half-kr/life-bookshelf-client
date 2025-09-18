package com.tdd.bookshelf.app.di

import com.tdd.bookshelf.feature.home.homeModule
import com.tdd.bookshelf.feature.interview.interviewModule
import com.tdd.bookshelf.feature.login.logInModule
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(
            commonModule,
            ktorModule,
            serviceModule,
            useCaseModule,
            dataSourceModule,
            repositoryModule,

            logInModule,
            homeModule,
            interviewModule
        )
    }
}