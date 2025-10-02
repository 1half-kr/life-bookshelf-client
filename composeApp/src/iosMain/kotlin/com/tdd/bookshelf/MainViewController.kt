package com.tdd.bookshelf

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import com.tdd.bookshelf.data.dataStore.createDataStore
import com.tdd.bookshelf.feature.MainScreen

fun MainViewController() = ComposeUIViewController {
    MainScreen(
        dataStore = remember { createDataStore() }
    )
}