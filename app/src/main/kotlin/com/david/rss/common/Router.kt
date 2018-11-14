package com.david.rss.common

import com.david.rss.domain.Rss

interface Router {
  fun navigateToDetail(rss: Rss)
  fun navigateToDetailWeb(url: String)
}
