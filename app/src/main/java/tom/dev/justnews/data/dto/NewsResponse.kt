package tom.dev.justnews.data.dto

import tom.dev.justnews.data.dto.enums.ResponseStatus

data class NewsResponse(
    val status: ResponseStatus,
    val totalResults: Int?,
    val articles: List<Article>?,
    val code: String?,
    val message: String?
)
