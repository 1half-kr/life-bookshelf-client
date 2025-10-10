package com.tdd.bookshelf.data.service

import com.tdd.bookshelf.data.base.EndPoints
import de.jensklingenberg.ktorfit.http.Multipart
import de.jensklingenberg.ktorfit.http.POST
import de.jensklingenberg.ktorfit.http.Part
import io.ktor.client.statement.HttpResponse

interface PublicationService {

    @Multipart
    @POST(EndPoints.Publication.PUBLICATIONS)
    suspend fun postPublication(
        @Part("title") title: String,
        @Part("preSignedCoverImageUrl") preSignedCoverImageUrl: String,
        @Part("titlePosition") titlePosition: String
    ): HttpResponse
}