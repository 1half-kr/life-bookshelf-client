package com.tdd.bookshelf.domain.usecase.interview

import com.tdd.bookshelf.domain.base.UseCase
import com.tdd.bookshelf.domain.repository.InterviewAIRepository
import kotlinx.coroutines.flow.Flow
import org.koin.core.annotation.Factory

@Factory
class PostInterviewRenewalUseCase(
    private val repository: InterviewAIRepository
): UseCase<Int, Result<Boolean>>() {

    override suspend fun invoke(request: Int): Flow<Result<Boolean>> =
        repository.postInterviewRenewal(request)
}