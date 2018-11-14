package com.david.rss.common

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import com.david.rss.detail.view.DetailActivity
import com.david.rss.domain.Rss
import com.david.rss.main.view.EXTRA_RSS

class RouterImpl constructor(private val activity: AppCompatActivity) : Router {

  override fun navigateToDetail(rss: Rss) {
    val intent = Intent(activity, DetailActivity::class.java)
    intent.putExtra(EXTRA_RSS, rss)
    activity.startActivity(intent)
  }

  override fun navigateToDetailWeb(url: String) {
    val intent = Intent(Intent.ACTION_VIEW)
    intent.data = Uri.parse(url)
    activity.startActivity(intent)
  }
}
