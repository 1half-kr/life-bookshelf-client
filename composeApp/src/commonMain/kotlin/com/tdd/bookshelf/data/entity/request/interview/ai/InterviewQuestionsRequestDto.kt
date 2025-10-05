package com.tdd.bookshelf.data.entity.request.interview.ai

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class InterviewQuestionsRequestDto(
    @SerialName("user_info")
    val userInfo: UserInfo = UserInfo(),
    @SerialName("chapter_info")
    val chapterInfo: ChapterInfo = ChapterInfo(),
    @SerialName("sub_chapter_info")
    val subChapterInfo: ChapterInfo = ChapterInfo(),
) {
    @Serializable
    data class UserInfo(
        @SerialName("user_name")
        val userName: String = "",
        @SerialName("date_of_birth")
        val birthDay: String = "",
        @SerialName("gender")
        val gender: String = "",
        @SerialName("has_children")
        val hasChildren: Boolean = false,
        @SerialName("occupation")
        val occupation: String = "",
        @SerialName("education_level")
        val educationLevel: String = "",
        @SerialName("marital_status")
        val maritalStatus: String = "",
    )

    @Serializable
    data class ChapterInfo(
        @SerialName("title")
        val title: String = "",
        @SerialName("description")
        val description: String = "",
    )
}