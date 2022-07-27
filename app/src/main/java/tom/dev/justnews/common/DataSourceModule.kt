package tom.dev.justnews.common

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import tom.dev.justnews.data.api.NewsApi
import tom.dev.justnews.data.datasource.NewsDataSource
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun providesNewsDataSource(
        @IoDispatcher ioDispatcher: CoroutineDispatcher,
        newsApi: NewsApi
    ): NewsDataSource {
        return NewsDataSource(ioDispatcher, newsApi)
    }
}