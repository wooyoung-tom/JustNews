package tom.dev.justnews.domain

import tom.dev.justnews.data.repository.NewsRepository
import javax.inject.Inject

class GetTopHeadlineArticlesUseCase
@Inject
constructor(
    private val newsRepository: NewsRepository
) {
    operator fun invoke() {

    }
}