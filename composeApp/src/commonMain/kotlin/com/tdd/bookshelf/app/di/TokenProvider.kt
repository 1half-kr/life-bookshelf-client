package com.tdd.bookshelf.app.di

import kotlin.concurrent.Volatile

class TokenProvider {
    @Volatile
    var accessToken: String? = null
}