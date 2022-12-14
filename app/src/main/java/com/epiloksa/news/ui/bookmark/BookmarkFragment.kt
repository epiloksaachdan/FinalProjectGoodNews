package com.epiloksa.news.ui.bookmark

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.epiloksa.news.databinding.CustomToolbarBinding
import com.epiloksa.news.databinding.FragmentBookmarkBinding
import com.epiloksa.news.source.news.ArticleModel
import com.epiloksa.news.ui.detail.DetailActivity
import com.epiloksa.news.ui.news.NewsAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.dsl.module

val bookmarkModule = module {
    factory { BookmarkFragment() }
}

class BookmarkFragment : Fragment() {

    private val viewModel: BookmarkViewModel by viewModel()
    private lateinit var binding: FragmentBookmarkBinding
    private lateinit var bindingToolbar: CustomToolbarBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBookmarkBinding.inflate(inflater, container, false)
        bindingToolbar = binding.toolbar
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        bindingToolbar.title = viewModel.title

        NewsAdapter.VIEW_TYPE = 2
        binding.listBookmark.adapter = adapter

        viewModel.articles.observe(viewLifecycleOwner, {
            adapter.clear()
            adapter.add( it )
        })
    }

    private val adapter by lazy {
        NewsAdapter(arrayListOf(), object: NewsAdapter.OnAdapterListener {
            override fun onClick(article: ArticleModel) {
                startActivity(
                        Intent(requireActivity(), DetailActivity::class.java)
                                .putExtra("detail", article)
                )
            }
        })
    }
}