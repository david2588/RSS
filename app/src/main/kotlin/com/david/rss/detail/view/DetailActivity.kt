package com.david.rss.detail.view

import android.os.Bundle
import android.view.View
import com.david.rss.common.BaseActivity
import com.david.rss.common.isAbsoluteUrl
import com.david.rss.common.load
import com.david.rss.common.loadHtml
import com.david.rss.detail.presenter.DetailPresenter
import com.david.rss.detail.presenter.DetailView
import com.david.rss.domain.Rss
import com.david.rss.main.R
import kotlinx.android.synthetic.main.activity_detail.descriptionTextView
import kotlinx.android.synthetic.main.activity_detail.imageImageView
import kotlinx.android.synthetic.main.activity_detail.titleTextView
import kotlinx.android.synthetic.main.activity_detail.verButton
import javax.inject.Inject

class DetailActivity : BaseActivity(), DetailView {

  @Inject
  lateinit var presenter: DetailPresenter

  private lateinit var rss: Rss

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_detail)
    initView()
    presenter.viewReady()
  }

  private fun initView() {
    initToolbar(resources.getString(R.string.detail_title_toolbar))

    verButton.setOnClickListener {
      rss.link?.let { it1 -> presenter.onButtonClicked(it1) }
    }
  }

  override fun displayDetail(rss: Rss) {
    this.rss = rss
    titleTextView.loadHtml(rss.title)
    descriptionTextView.loadHtml(rss.description)
    rss.image?.let {
      if (it.isAbsoluteUrl()) {
        imageImageView.visibility = View.VISIBLE
        imageImageView.load(it)
      }
    }

    rss.link?.let { verButton.visibility = View.VISIBLE }
  }


}
