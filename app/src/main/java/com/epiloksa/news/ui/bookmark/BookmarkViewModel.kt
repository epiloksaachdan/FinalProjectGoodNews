package com.epiloksa.news.ui.bookmark

import androidx.lifecycle.ViewModel
import com.epiloksa.news.source.news.NewsRepository
import org.koin.dsl.module

val bookmarkViewModel = module {
    factory { BookmarkViewModel(get()) }
}

class BookmarkViewModel(
    repository: NewsRepository
) : ViewModel() {

    val title = "saved"
    val articles = repository.db.findAll()

}