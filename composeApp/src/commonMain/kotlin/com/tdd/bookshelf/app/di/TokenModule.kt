package com.tdd.bookshelf.app.di

import com.tdd.bookshelf.data.dataStore.LocalDataStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.core.qualifier.named
import org.koin.dsl.module

private val APP_SCOPE = named("AppScope")

val tokenModule = module {
    single { TokenProvider() }

    single(APP_SCOPE) { CoroutineScope(SupervisorJob() + Dispatchers.Default) }

    single {
        TokenSynchronizer(
            localDataStore = get<LocalDataStore>(),
            tokenProvider = get<TokenProvider>(),
            scope = get(APP_SCOPE)
        )
    }

    single(createdAtStart = true) {
        get<TokenSynchronizer>().start()
        object {}
    }
}