package com.tdd.bookshelf.app.di

import com.tdd.bookshelf.feature.login.logInModule
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(
            commonModule,
            logInModule,
        )
    }
}