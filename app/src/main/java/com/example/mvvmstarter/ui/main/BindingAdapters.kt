package com.example.mvvmstarter.ui.main

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mvvmstarter.R

@BindingAdapter("setImage")
fun ImageView.setImage(item:String?){
    val requestOptions = RequestOptions()
        .placeholder(R.drawable.ic_launcher_background)
        .error(R.drawable.ic_launcher_foreground)
    item?.let {
        Glide.with(this.context)
            .setDefaultRequestOptions(requestOptions)
            .load(it)
            .fitCenter()
            .into(this)
    }
}

class BindingAdapters{
    companion object{

    }

}