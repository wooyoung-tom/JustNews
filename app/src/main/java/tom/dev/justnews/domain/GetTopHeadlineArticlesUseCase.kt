package tom.dev.justnews.domain

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import tom.dev.justnews.data.dto.NewsResponse
import tom.dev.justnews.data.repository.NewsRepository
import javax.inject.Inject

class GetTopHeadlineArticlesUseCase
@Inject
constructor(
    private val ioDispatcher: CoroutineDispatcher,
    private val newsRepository: NewsRepository
) {
    suspend operator fun invoke(): NewsResponse {
        return withContext(ioDispatcher) {
            newsRepository.getTopHeadlineArticles()
        }
    }
}