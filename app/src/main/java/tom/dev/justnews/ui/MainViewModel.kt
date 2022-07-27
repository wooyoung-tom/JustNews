package tom.dev.justnews.ui

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import tom.dev.justnews.domain.GetTopHeadlineArticlesUseCase
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject
constructor(
    private val getTopHeadlineArticlesUseCase: GetTopHeadlineArticlesUseCase
) : ViewModel() {


}