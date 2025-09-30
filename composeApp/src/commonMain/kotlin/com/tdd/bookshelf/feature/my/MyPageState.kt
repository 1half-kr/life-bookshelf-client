package com.tdd.bookshelf.feature.my

import com.tdd.bookshelf.core.designsystem.Rejected
import com.tdd.bookshelf.core.ui.base.PageState
import com.tdd.bookshelf.domain.entity.response.publication.PublishBookListItemModel

data class MyPageState(
    val publishStatus: String = Rejected,
    val publishBookList: List<PublishBookListItemModel> = emptyList(),
    val isAlarmActivated: Boolean = false
) : PageState