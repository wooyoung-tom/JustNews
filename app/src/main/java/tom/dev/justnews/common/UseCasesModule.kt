package tom.dev.justnews.common

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import tom.dev.justnews.data.repository.NewsRepository
import tom.dev.justnews.domain.GetTopHeadlineArticlesUseCase
import javax.inject.Singleton

/*
 * UseCases module will be installed in ViewModel scope
 */
@Module
@InstallIn(SingletonComponent::class)
object UseCasesModule {

    @Provides
    @Singleton
    fun provideGetTopHeadlineArticlesUseCase(
        @IoDispatcher ioDispatcher: CoroutineDispatcher,
        newsRepository: NewsRepository
    ): GetTopHeadlineArticlesUseCase {
        return GetTopHeadlineArticlesUseCase(ioDispatcher, newsRepository)
    }
}