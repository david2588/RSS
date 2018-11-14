package com.david.rss.main.presenter

import com.david.rss.domain.Rss

interface MainView {
  fun displayList(list: List<Rss>)
}