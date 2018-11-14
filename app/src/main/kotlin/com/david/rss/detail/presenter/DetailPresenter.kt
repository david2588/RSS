package com.david.rss.detail.presenter

import com.david.rss.common.Router
import com.david.rss.common.weak
import com.david.rss.domain.Rss

class DetailPresenter constructor(
    detailView: DetailView,
    private val router: Router,
    private val rss: Rss
) {

  val view: DetailView? by weak(detailView)

  fun viewReady() {
    view?.displayDetail(rss)
  }

  fun onButtonClicked(url: String) {
    router.navigateToDetailWeb(url)
  }
}
