package com.tdd.bookshelf.domain.entity.response.member

data class MemberInfoModel(
    val name: String = "",
    val bornedAt: String = "",
    val gender: String = "",
    val hasChildren: String = "",
    val occupation: String = "",
    val educationLevel: String = "",
    val maritalStatus: String = "",
)