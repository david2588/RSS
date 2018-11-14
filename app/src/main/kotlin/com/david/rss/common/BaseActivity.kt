package com.david.rss.common

import android.view.MenuItem
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.toolbar.toolbar
import kotlinx.android.synthetic.main.toolbar.toolbar_title


abstract class BaseActivity : DaggerAppCompatActivity() {

  fun initToolbar(title: String) {
    if (toolbar != null) {
      setSupportActionBar(toolbar)
      supportActionBar?.setDisplayShowTitleEnabled(false)
      supportActionBar?.setDisplayHomeAsUpEnabled(true)
      toolbar_title.text = title
    }
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    return when (item.itemId) {
      android.R.id.home -> {
        onBackPressed()
        true
      }
      else -> super.onOptionsItemSelected(item)
    }
  }
}
