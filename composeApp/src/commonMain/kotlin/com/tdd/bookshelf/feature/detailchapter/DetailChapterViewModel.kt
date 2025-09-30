package com.tdd.bookshelf.feature.detailchapter

import com.tdd.bookshelf.core.ui.base.BaseViewModel
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class DetailChapterViewModel: BaseViewModel<DetailChapterPageState>(
    DetailChapterPageState()
) {
}