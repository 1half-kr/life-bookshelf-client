package com.tdd.bookshelf.feature.interview

import com.tdd.bookshelf.core.ui.base.BaseViewModel
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class InterviewViewModel: BaseViewModel<InterviewPageState>(
    InterviewPageState()
) {
}