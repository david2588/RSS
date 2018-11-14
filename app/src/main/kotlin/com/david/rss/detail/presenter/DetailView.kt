package com.david.rss.detail.presenter

import com.david.rss.domain.Rss

interface DetailView {
  fun displayDetail(rss: Rss)
}