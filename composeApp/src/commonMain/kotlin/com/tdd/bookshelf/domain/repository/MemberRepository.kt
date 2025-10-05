package com.tdd.bookshelf.domain.repository

import com.tdd.bookshelf.domain.entity.response.member.MemberInfoModel
import kotlinx.coroutines.flow.Flow

interface MemberRepository {
    suspend fun getMemberInfo(): Flow<Result<MemberInfoModel>>
}