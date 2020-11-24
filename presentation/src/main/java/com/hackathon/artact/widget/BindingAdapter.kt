package com.hackathon.artact.widget

import android.content.ContextWrapper
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.hackathon.artact.R

fun View.getParentActivity(): AppCompatActivity?{
    var context = this.context
    while (context is ContextWrapper) {
        if (context is AppCompatActivity) {
            return context
        }
        context = context.baseContext
    }
    return null
}

@BindingAdapter("mutableImageUrl")
fun setMutableImageUrl(view: ImageView, url: MutableLiveData<String>?) {
    val parentActivity: AppCompatActivity = view.getParentActivity() ?: return

    if(url != null) {
        url.observe(parentActivity, Observer { value ->
            Glide.with(view.context)
                .load(value)
                .error(R.drawable.sample)
                .into(view)
        })
    }
    else {
        Glide.with(view.context)
            .load(R.drawable.sample)
            .into(view)
    }
}