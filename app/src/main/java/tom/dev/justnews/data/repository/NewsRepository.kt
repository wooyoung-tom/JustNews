package tom.dev.justnews.data.repository

import tom.dev.justnews.data.dto.NewsResponse

interface NewsRepository {
    suspend fun getTopHeadlineArticles(): NewsResponse
}