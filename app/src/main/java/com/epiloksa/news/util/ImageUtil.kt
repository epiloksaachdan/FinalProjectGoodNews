package com.epiloksa.news.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.epiloksa.news.R

@BindingAdapter("loadImage")
fun loadImage(imageView: ImageView, urlString: String?){
    urlString?.let {
        Glide.with(imageView)
            .load( urlString )
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.placeholder)
            .into( imageView )
    }
}