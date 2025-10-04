package com.tdd.bookshelf.domain.entity.response.autobiography

data class AutobiographiesDetailModel(
    val autobiographyId: Int = 0,
    val interviewId: Int = 0,
    val title: String = "",
    val content: String = "",
    val coverImageUrl: String = "",
    val createdAt: String = "",
    val updatedAt: String = "",
)