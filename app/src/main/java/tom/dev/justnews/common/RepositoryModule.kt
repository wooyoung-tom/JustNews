package tom.dev.justnews.common

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import tom.dev.justnews.data.api.NewsApi
import tom.dev.justnews.data.datasource.NewsDataSource
import tom.dev.justnews.data.repository.NewsRepository
import tom.dev.justnews.data.repository.NewsRepositoryImpl
import javax.inject.Singleton

/*
 * Repository module will be installed in Application scope
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Provides
    @Singleton
    fun providesNewsDataSource(newsApi: NewsApi): NewsDataSource {
        return NewsDataSource(newsApi)
    }

    @Binds
    abstract fun bindsNewsRepository(newsRepositoryImpl: NewsRepositoryImpl): NewsRepository
}