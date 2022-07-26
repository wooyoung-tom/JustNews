package tom.dev.justnews.common

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import tom.dev.justnews.domain.GetTopHeadlineArticlesUseCase
import javax.inject.Singleton

/*
 * UseCases module will be installed in ViewModel scope
 */
@Module
@InstallIn(ViewModelComponent::class)
object UseCasesModule {

    @Provides
    @Singleton
    fun provideGetTopHeadlineArticlesUseCase(): GetTopHeadlineArticlesUseCase {

    }
}