package com.david.rss.common

import android.os.Build
import android.support.v7.widget.RecyclerView
import android.text.Html
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.request.RequestOptions

fun ViewGroup.inflate(itemHolder: Int): View = LayoutInflater.from(context).inflate(itemHolder, this, false)

inline fun <reified T : View> View.find(idRes: Int): T = findViewById(idRes)

inline fun <reified T : View> RecyclerView.ViewHolder.find(idRes: Int): T = itemView.find(idRes)


fun ImageView.load(path: Any, holder: Int? = null, error: Int? = null, isCircle: Boolean = false) = GlideApp.with(context)
    .load(path)
    .apply {
      val reqOptions = if (isCircle) {
        RequestOptions.circleCropTransform()
      } else {
        RequestOptions()
      }
      if (holder != null) {
        reqOptions.placeholder(holder)
      }
      if (error != null) {
        reqOptions.error(error)
      }
      this.apply(reqOptions)
    }
    .into(this)

fun String.isAbsoluteUrl(): Boolean {
  return Patterns.WEB_URL.matcher(this).matches()
}

fun TextView.loadHtml(text: String?) {
  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
    this.text = Html.fromHtml(Html.fromHtml(text, Html.FROM_HTML_MODE_LEGACY).toString(), Html.FROM_HTML_MODE_LEGACY)
  } else {
    this.text = Html.fromHtml(text)
  }
}