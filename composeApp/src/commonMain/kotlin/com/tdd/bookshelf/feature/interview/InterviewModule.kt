package com.tdd.bookshelf.feature.interview

import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

@Module
@ComponentScan("com.tdd.bookshelf.feature.interview")
class InterviewModule

val interviewModule = module {
    viewModel {
        InterviewViewModel()
    }
}