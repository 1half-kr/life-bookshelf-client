package com.tdd.bookshelf.app.di

import com.tdd.bookshelf.data.service.AuthService
import com.tdd.bookshelf.data.service.createAuthService
import de.jensklingenberg.ktorfit.Ktorfit
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import org.koin.dsl.module

val serviceModule = module {
    single { ServiceModule().provideAuthService(get()) }
}

@Module
@ComponentScan
class ServiceModule {

    @Single
    fun provideAuthService(
        ktorfit: Ktorfit,
    ): AuthService = ktorfit.createAuthService()
}