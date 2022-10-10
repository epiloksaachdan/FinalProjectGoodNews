package com.epiloksa.news

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.epiloksa.news.source.network.networkModule
import com.epiloksa.news.source.news.repositoryModule
import com.epiloksa.news.source.persistence.databaseModule
import com.epiloksa.news.ui.bookmark.bookmarkModule
import com.epiloksa.news.ui.bookmark.bookmarkViewModel
import com.epiloksa.news.ui.detail.detailModule
import com.epiloksa.news.ui.detail.detailViewModel
import com.epiloksa.news.ui.home.homeModule
import com.epiloksa.news.ui.home.homeViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class NewsApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        startKoin {
            androidLogger()
            androidContext(this@NewsApp)
            modules(
                networkModule,
                databaseModule,
                repositoryModule,
                homeModule,
                homeViewModel,
                bookmarkModule,
                bookmarkViewModel,
                detailModule,
                detailViewModel
            )
        }
    }
}