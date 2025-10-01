package com.tdd.bookshelf.data.entity.response.autobiography

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AllAutobiographyResponseDto(
    @SerialName("results")
    val results: List<AutobiographyItem>,
    @SerialName("currentPage")
    val currentPage: Int,
    @SerialName("totalPages")
    val totalPages: Int,
    @SerialName("totalElements")
    val totalElements: Int,
    @SerialName("isLast")
    val isLast: Boolean,
) {
    @Serializable
    data class AutobiographyItem(
        @SerialName("autobiographyId")
        val autobiographyId: Int,
        @SerialName("interviewId")
        val interviewId: Int,
        @SerialName("chapterId")
        val chapterId: Int,
        @SerialName("title")
        val title: String,
        @SerialName("contentPreview")
        val contentPreview: String,
        @SerialName("coverImageUrl")
        val coverImageUrl: String,
        @SerialName("createdAt")
        val createdAt: String,
        @SerialName("updatedAt")
        val updatedAt: String,
    )
}