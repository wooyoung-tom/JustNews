package tom.dev.justnews.data.dto

data class HeadlineArticle(
    val source: NewsSource? = NewsSource(),
    val author: String? = "Invalid Author",
    val title: String? = "Invalid Title",
    val description: String? = "Invalid Description",
    val url: String? = "Invalid URL",
    val urlToImage: String? = "Invalid Thumbnail URL",
    val publishedAt: String? = "Invalid Published Time",
    val content: String? = "Invalid Content"
)