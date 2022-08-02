package tom.dev.justnews.ui.home

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import tom.dev.justnews.data.dto.Article
import tom.dev.justnews.databinding.ListItemNewsBinding

class HomeArticleListViewHolder(
    private val binding: ListItemNewsBinding
) : ViewHolder(binding.root) {

    fun bind(item: Article) {
        binding.listItemNewsTitle.text = item.title
    }
}