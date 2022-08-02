package tom.dev.justnews.data.dto

import androidx.recyclerview.widget.DiffUtil

data class Article(
    val source: ArticleSource? = ArticleSource(),
    val author: String? = "Invalid Author",
    val title: String? = "Invalid Title",
    val description: String? = "Invalid Description",
    val url: String? = "Invalid URL",
    val urlToImage: String? = "Invalid Thumbnail URL",
    val publishedAt: String? = "Invalid Published Time",
    val content: String? = "Invalid Content"
) {
    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Article>() {
            override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
                return oldItem.source?.id == newItem.source?.id
            }

            override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
                return oldItem == newItem
            }
        }
    }
}