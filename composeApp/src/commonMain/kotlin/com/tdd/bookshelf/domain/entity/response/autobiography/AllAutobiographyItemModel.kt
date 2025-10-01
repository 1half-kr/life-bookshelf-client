package com.tdd.bookshelf.domain.entity.response.autobiography

data class AllAutobiographyItemModel(
    val chapterId: Int = 0,
    val title: String = "",
    val contentPreview: String = "",
    val coverImageUrl: String = "",
    val createdAt: String = "",
    val updatedAt: String = "",
)