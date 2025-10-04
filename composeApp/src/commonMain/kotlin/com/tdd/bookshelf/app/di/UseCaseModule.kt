package com.tdd.bookshelf.app.di

import com.tdd.bookshelf.domain.usecase.auth.PostEmailLogInUseCase
import com.tdd.bookshelf.domain.usecase.auth.SaveTokenUseCase
import com.tdd.bookshelf.domain.usecase.autobiograph.GetAllAutobiographyUseCase
import com.tdd.bookshelf.domain.usecase.autobiograph.GetAutobiographiesDetailUseCase
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.dsl.module

@Module
@ComponentScan("com.tdd.bookshelf.domain")
class UseCaseModule

val useCaseModule = module {
    // Auth
    factory { PostEmailLogInUseCase(get()) }
    factory { SaveTokenUseCase(get()) }

    // Autobiography
    factory {  GetAllAutobiographyUseCase(get()) }
    factory { GetAutobiographiesDetailUseCase(get()) }
}