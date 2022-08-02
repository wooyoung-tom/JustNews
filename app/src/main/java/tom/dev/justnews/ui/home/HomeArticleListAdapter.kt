package tom.dev.justnews.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import tom.dev.justnews.data.dto.Article
import tom.dev.justnews.databinding.ListItemNewsBinding

class HomeArticleListAdapter : ListAdapter<Article, HomeArticleListViewHolder>(Article.diffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeArticleListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListItemNewsBinding.inflate(layoutInflater)
        return HomeArticleListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeArticleListViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(item = it)
        }
    }
}