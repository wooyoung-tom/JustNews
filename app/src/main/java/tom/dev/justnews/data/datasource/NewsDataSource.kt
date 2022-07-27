package tom.dev.justnews.data.datasource

import tom.dev.justnews.data.api.NewsApi
import javax.inject.Inject

class NewsDataSource
@Inject
constructor(
    private val newsApi: NewsApi
) {
    suspend fun getTopHeadlineArticles()
}