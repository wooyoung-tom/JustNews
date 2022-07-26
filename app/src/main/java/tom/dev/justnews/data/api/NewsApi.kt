package tom.dev.justnews.data.api

import retrofit2.http.GET
import retrofit2.http.Query
import tom.dev.justnews.data.dto.NewsResponse
import tom.dev.justnews.data.dto.enums.Category
import tom.dev.justnews.data.dto.enums.Country

interface NewsApi {

    @GET("/v2/top-headlines")
    suspend fun getTopHeadlineArticles(
        @Query("country") country: Country,
        @Query("category") category: Category,
        @Query("q") keyword: String?,
        @Query("pageSize") pageSize: Int,
        @Query("page") page: Int
    ): NewsResponse

    @GET("/v2/top-headlines/sources")
    fun getTopHeadlineArticlesFilterBySources(
        @Query("sources") sources: String?,
        @Query("q") keyword: String?,
        @Query("pageSize") pageSize: Int,
        @Query("page") page: Int
    )
}