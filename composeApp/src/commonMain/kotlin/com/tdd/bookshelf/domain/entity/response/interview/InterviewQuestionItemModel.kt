package com.tdd.bookshelf.domain.entity.response.interview

import kotlinx.serialization.SerialName

data class InterviewQuestionItemModel (
    val questionId: Int = 0,
    val order: Int = 0,
    val questionText: String = "",
)