package tom.dev.justnews.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import tom.dev.justnews.domain.GetTopHeadlineArticlesUseCase
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject
constructor(
    private val getTopHeadlineArticlesUseCase: GetTopHeadlineArticlesUseCase
) : ViewModel() {

    fun getTop() {
        viewModelScope.launch {
            val response = getTopHeadlineArticlesUseCase.invoke()
            Log.d("MainViewModel", "getTop: $response")
        }
    }
}