package tom.dev.justnews.data.datasource

import kotlinx.coroutines.CoroutineDispatcher
import tom.dev.justnews.data.api.NewsApi
import tom.dev.justnews.data.dto.NewsResponse
import javax.inject.Inject

class NewsDataSource
@Inject
constructor(
    private val ioDispatcher: CoroutineDispatcher,
    private val newsApi: NewsApi
) {
    suspend fun getTopHeadlineArticles(): NewsResponse {
        return newsApi.getTopHeadlineArticles()
    }
}