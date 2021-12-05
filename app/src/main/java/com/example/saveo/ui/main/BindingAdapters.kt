package com.example.saveo.ui.main

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.saveo.R
import com.example.saveo.models.Name

@BindingAdapter("setImage")
fun ImageView.setImage(item:String?){
    val requestOptions = RequestOptions()
        .placeholder(R.drawable.img_loading)
        .error(R.drawable.err_image)
    item?.let {
        Glide.with(this.context)
            .setDefaultRequestOptions(requestOptions)
            .load(it)
            .fitCenter()
            .into(this)
    }
}

@BindingAdapter("setName")
fun TextView.setName(item:Name?){
    item?.let { name ->
        "${name.title} ${name.first} ${name.last}".also { text = it }
    }
}
