package com.tdd.bookshelf.feature.my

import com.tdd.bookshelf.core.designsystem.Rejected
import com.tdd.bookshelf.core.ui.base.PageState

data class MyPageState(
    val publishStatus: String = Rejected,
) : PageState