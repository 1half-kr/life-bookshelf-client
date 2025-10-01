package com.tdd.bookshelf.app.di

import com.tdd.bookshelf.data.repositoryImpl.AuthRepositoryImpl
import com.tdd.bookshelf.data.repositoryImpl.AutobiographyRepositoryImpl
import com.tdd.bookshelf.domain.repository.AuthRepository
import com.tdd.bookshelf.domain.repository.AutobiographyRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<AuthRepository> { AuthRepositoryImpl(get()) }
    single<AutobiographyRepository> { AutobiographyRepositoryImpl(get()) }
}