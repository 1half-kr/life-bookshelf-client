package com.tdd.bookshelf.app.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.tdd.bookshelf.data.dataStore.createDataStore
import com.tdd.bookshelf.data.dataStore.dataStoreFileName
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val androidDataStoreModule =
    module {
        single<DataStore<Preferences>> {
            val context: Context = androidContext()
            val path = context.filesDir.resolve(dataStoreFileName).absolutePath

            createDataStore { path }
        }
    }
