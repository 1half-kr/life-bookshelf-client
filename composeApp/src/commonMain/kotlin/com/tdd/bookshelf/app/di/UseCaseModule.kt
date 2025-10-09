package com.tdd.bookshelf.app.di

import com.tdd.bookshelf.domain.usecase.auth.PostEmailLogInUseCase
import com.tdd.bookshelf.domain.usecase.auth.SaveTokenUseCase
import com.tdd.bookshelf.domain.usecase.autobiograph.DeleteAutobiographyUseCase
import com.tdd.bookshelf.domain.usecase.autobiograph.GetAllAutobiographyUseCase
import com.tdd.bookshelf.domain.usecase.autobiograph.GetAutobiographiesChapterListUseCase
import com.tdd.bookshelf.domain.usecase.autobiograph.GetAutobiographiesDetailUseCase
import com.tdd.bookshelf.domain.usecase.autobiograph.PostCreateAutobiographyChaptersUseCase
import com.tdd.bookshelf.domain.usecase.autobiograph.PostCreateAutobiographyUseCase
import com.tdd.bookshelf.domain.usecase.autobiograph.PostEditAutobiographyDetailUseCase
import com.tdd.bookshelf.domain.usecase.autobiograph.PostUpdateCurrentChapterUseCase
import com.tdd.bookshelf.domain.usecase.interview.ai.PostCreateInterviewQuestionUseCase
import com.tdd.bookshelf.domain.usecase.member.GetMemberInfoUseCase
import com.tdd.bookshelf.domain.usecase.member.GetMemberProfileUseCase
import com.tdd.bookshelf.domain.usecase.member.PutEditMemberInfoUseCase
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.dsl.module

@Module
@ComponentScan("com.tdd.bookshelf.domain")
class UseCaseModule

val useCaseModule = module {
    // Auth
    factory { PostEmailLogInUseCase(get()) }
    factory { SaveTokenUseCase(get()) }

    // Autobiography
    factory { GetAllAutobiographyUseCase(get()) }
    factory { PostCreateAutobiographyUseCase(get()) }
    factory { GetAutobiographiesDetailUseCase(get()) }
    factory { PostEditAutobiographyDetailUseCase(get()) }
    factory { DeleteAutobiographyUseCase(get()) }
    factory { GetAutobiographiesChapterListUseCase(get()) }
    factory { PostCreateAutobiographyChaptersUseCase(get()) }
    factory { PostUpdateCurrentChapterUseCase(get()) }

    // Member
    factory { GetMemberInfoUseCase(get()) }
    factory { PutEditMemberInfoUseCase(get()) }
    factory { GetMemberProfileUseCase(get()) }

    // AI
    // Interview
    factory { PostCreateInterviewQuestionUseCase(get()) }
}