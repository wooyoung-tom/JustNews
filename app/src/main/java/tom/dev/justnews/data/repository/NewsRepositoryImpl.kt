package tom.dev.justnews.data.repository

import tom.dev.justnews.data.datasource.NewsDataSource
import javax.inject.Inject

class NewsRepositoryImpl
@Inject
constructor(
    private val newsDataSource: NewsDataSource
) : NewsRepository {

}