package com.tdd.bookshelf.data.service

import com.tdd.bookshelf.data.base.EndPoints
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
}