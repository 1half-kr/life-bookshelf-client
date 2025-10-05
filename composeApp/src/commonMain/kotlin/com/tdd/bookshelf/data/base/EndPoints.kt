package com.tdd.bookshelf.data.base

object EndPoints {

    object Auth {
        const val EMAILLOGIN = "api/v1/auth/email-login"
    }

    object Autobiography {
        const val AUTOBIOGRAPHIES = "api/v1/autobiographies"
        const val AUTOBIOGRAPHIESDETAIL = "$AUTOBIOGRAPHIES/{autobiographyId}"
        const val AUTOBIOGRAPHIESCHAPTER = "$AUTOBIOGRAPHIES/chapters"
        const val UPDATECURRENTCHAPTER = "$AUTOBIOGRAPHIESCHAPTER/current-chapter"
    }

    object Member {
        const val MEMBER = "api/v1/members/me"
    }

    object Interview {
        const val INTERVIEWQUESTION = "api/v1/interviews/interview-questions"
    }
}