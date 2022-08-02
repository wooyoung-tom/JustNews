package tom.dev.justnews.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import tom.dev.justnews.data.dto.Article
import tom.dev.justnews.data.dto.enums.ResponseStatus
import tom.dev.justnews.domain.GetTopHeadlineArticlesUseCase
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject
constructor(
    private val getTopHeadlineArticlesUseCase: GetTopHeadlineArticlesUseCase
) : ViewModel() {

    private val _headlines: MutableStateFlow<List<Article>> = MutableStateFlow(emptyList())
    val headlines: StateFlow<List<Article>> get() = _headlines

    fun getTopHeadlines() {
        viewModelScope.launch {
            val response = getTopHeadlineArticlesUseCase.invoke()
            when (response.status) {
                ResponseStatus.ok -> onArticleFetchedSuccess(response.articles)
                ResponseStatus.error -> onError(response.code, response.message)
            }
        }
    }

    private suspend fun onArticleFetchedSuccess(articles: List<Article>?) {
        articles?.let {
            _headlines.emit(value = it)
        }
    }

    private suspend fun onError(code: String?, message: String?) {
        Log.d("HomeViewModel", "onError: $code / $message")
    }
}