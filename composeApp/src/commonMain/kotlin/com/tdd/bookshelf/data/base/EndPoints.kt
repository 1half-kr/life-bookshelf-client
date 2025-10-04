package com.tdd.bookshelf.data.base

object EndPoints {

    object Auth {
        const val EMAILLOGIN = "api/v1/auth/email-login"
    }

    object Autobiography {
        const val AUTOBIOGRAPHIES = "api/v1/autobiographies"
        const val AUTOBIOGRAPHIESDETAIL = "$AUTOBIOGRAPHIES/{autobiographyId}"
    }
}