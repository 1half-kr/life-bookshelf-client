package com.tdd.bookshelf.app.di

import com.tdd.bookshelf.feature.detailchapter.DetailChapterViewModel
import com.tdd.bookshelf.feature.home.HomeViewModel
import com.tdd.bookshelf.feature.interview.InterviewViewModel
import com.tdd.bookshelf.feature.login.LogInViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { LogInViewModel(get()) }
    viewModel { InterviewViewModel()}
    viewModel { HomeViewModel() }
    viewModel { DetailChapterViewModel() }
}
