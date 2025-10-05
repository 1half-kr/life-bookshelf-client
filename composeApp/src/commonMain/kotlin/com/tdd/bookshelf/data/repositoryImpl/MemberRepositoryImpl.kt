package com.tdd.bookshelf.data.repositoryImpl

import com.tdd.bookshelf.data.dataSource.MemberDataSource
import com.tdd.bookshelf.data.mapper.member.MemberInfoMapper
import com.tdd.bookshelf.domain.entity.response.member.MemberInfoModel
import com.tdd.bookshelf.domain.repository.MemberRepository
import kotlinx.coroutines.flow.Flow
import org.koin.core.annotation.Single

@Single(binds = [MemberRepository::class])
class MemberRepositoryImpl(
    private val memberDataSource: MemberDataSource,
) : MemberRepository {

    override suspend fun getMemberInfo(): Flow<Result<MemberInfoModel>> =
        MemberInfoMapper.responseToModel(apiCall = { memberDataSource.getMemberInfo() })
}