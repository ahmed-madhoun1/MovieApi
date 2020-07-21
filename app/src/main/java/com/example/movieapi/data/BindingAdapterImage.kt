package com.example.movieapi.data

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("image")
fun loadUrlImage(imgView: ImageView, URL: String) {
    Glide.with(imgView)
        .load(URL)
        .into(imgView)
}
