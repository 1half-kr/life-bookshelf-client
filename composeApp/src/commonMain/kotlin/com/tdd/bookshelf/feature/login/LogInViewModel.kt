package com.tdd.bookshelf.feature.login

import com.tdd.bookshelf.core.ui.base.BaseViewModel
import com.tdd.bookshelf.core.ui.base.PageState
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class LogInViewModel: BaseViewModel<PageState.Default>(
    PageState.Default
) {
}