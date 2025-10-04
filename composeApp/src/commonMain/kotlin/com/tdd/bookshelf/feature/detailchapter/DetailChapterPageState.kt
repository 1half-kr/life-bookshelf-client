package com.tdd.bookshelf.feature.detailchapter

import com.tdd.bookshelf.core.ui.base.PageState

data class DetailChapterPageState (
    val selectedAutobiographyId: Int = 0
): PageState