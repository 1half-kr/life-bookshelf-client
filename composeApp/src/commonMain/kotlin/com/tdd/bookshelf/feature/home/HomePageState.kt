package com.tdd.bookshelf.feature.home

import com.tdd.bookshelf.core.ui.base.PageState
import com.tdd.bookshelf.domain.entity.response.autobiography.ChapterListModel

data class HomePageState (
    val chapterList: ChapterListModel = ChapterListModel()
): PageState