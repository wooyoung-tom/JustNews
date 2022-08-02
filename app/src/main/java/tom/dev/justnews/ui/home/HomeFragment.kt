package tom.dev.justnews.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import tom.dev.justnews.databinding.FragmentHomeBinding

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = _binding!!

    private val viewModel by viewModels<HomeViewModel>()

    private lateinit var homeArticleListAdapter: HomeArticleListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerViewAdapter()

        viewModel.getTopHeadlines()

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.headlines.collectLatest {
                homeArticleListAdapter.submitList(it)
            }
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    private fun initRecyclerViewAdapter() {
        homeArticleListAdapter = HomeArticleListAdapter()
        binding.homeNewsRecyclerView.adapter = homeArticleListAdapter
    }
}