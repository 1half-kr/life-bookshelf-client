package com.tdd.bookshelf.feature.login

import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

@Module
@ComponentScan("com.tdd.bookshelf.feature.login")
class LogInModule

val logInModule = module {
    viewModel {
        LogInViewModel(get())
    }
}