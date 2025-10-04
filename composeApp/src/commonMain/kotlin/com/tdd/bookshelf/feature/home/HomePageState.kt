package com.tdd.bookshelf.feature.home

import com.tdd.bookshelf.core.ui.base.PageState
import com.tdd.bookshelf.domain.entity.response.autobiography.ChapterItemModel
import com.tdd.bookshelf.domain.entity.response.autobiography.SubChapterItemModel

data class HomePageState(
    val chapterList: List<ChapterItemModel> = emptyList(),
    val subChapterList: List<SubChapterItemModel> = emptyList(),
    val currentChapterId: Int = 0,
    val currentChapter: SubChapterItemModel = SubChapterItemModel()
) : PageState