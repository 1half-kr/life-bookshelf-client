package com.tdd.bookshelf.app.di

import com.tdd.bookshelf.data.repositoryImpl.AuthRepositoryImpl
import com.tdd.bookshelf.domain.repository.AuthRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<AuthRepository> { AuthRepositoryImpl(get()) }
}