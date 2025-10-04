package com.tdd.bookshelf.data.service

import com.tdd.bookshelf.data.base.EndPoints
import de.jensklingenberg.ktorfit.http.DELETE
import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Path
import io.ktor.client.statement.HttpResponse

interface AutobiographyService {

    @GET(EndPoints.Autobiography.AUTOBIOGRAPHIES)
    suspend fun getAllAutobiographies(): HttpResponse

    @GET(EndPoints.Autobiography.AUTOBIOGRAPHIESDETAIL)
    suspend fun getAutobiographiesDetail(
        @Path("autobiographyId") autobiographyId: Int
    ): HttpResponse

    @DELETE(EndPoints.Autobiography.AUTOBIOGRAPHIESDETAIL)
    suspend fun deleteAutobiography(
        @Path("autobiographyId") autobiographyId: Int
    ): HttpResponse

    @GET(EndPoints.Autobiography.AUTOBIOGRAPHIESCHAPTER)
    suspend fun getAutobiographiesChapter(): HttpResponse
}