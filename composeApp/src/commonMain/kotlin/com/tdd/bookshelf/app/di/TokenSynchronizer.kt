package com.tdd.bookshelf.app.di

import com.tdd.bookshelf.data.dataStore.LocalDataStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class TokenSynchronizer(
    private val localDataStore: LocalDataStore,
    private val tokenProvider: TokenProvider,
    private val scope: CoroutineScope,
) {
    private var job: Job? = null

    fun start() {
        if (job != null) return
        job = scope.launch {
            localDataStore.accessToken.collectLatest { token ->
                tokenProvider.accessToken = token
            }
        }
    }
}