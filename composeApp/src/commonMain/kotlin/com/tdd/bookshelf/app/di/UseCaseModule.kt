package com.tdd.bookshelf.app.di

import com.tdd.bookshelf.domain.usecase.auth.PostEmailLogInUseCase
import com.tdd.bookshelf.domain.usecase.autobiograph.GetAllAutobiographyUseCase
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.dsl.module

@Module
@ComponentScan("com.tdd.bookshelf.domain")
class UseCaseModule

val useCaseModule = module {
    factory {
        // Auth
        PostEmailLogInUseCase(get())

        // Autobiography
        GetAllAutobiographyUseCase(get())
    }
}