package tom.dev.justnews.data.repository

import tom.dev.justnews.data.datasource.NewsDataSource
import tom.dev.justnews.data.dto.NewsResponse
import javax.inject.Inject

class NewsRepositoryImpl
@Inject
constructor(
    private val newsDataSource: NewsDataSource
) : NewsRepository {

    override suspend fun getTopHeadlineArticles(): NewsResponse {
        return newsDataSource.getTopHeadlineArticles()
    }
}