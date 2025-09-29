package com.tdd.bookshelf.feature.my

import com.tdd.bookshelf.core.ui.base.BaseViewModel
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class MyViewModel: BaseViewModel<MyPageState>(
    MyPageState()
) {
}