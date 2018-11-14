package com.david.rss.main.view

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import com.david.rss.common.BaseActivity
import com.david.rss.domain.Rss
import com.david.rss.main.R
import com.david.rss.main.presenter.MainPresenter
import com.david.rss.main.presenter.MainView
import com.david.rss.main.view.adapter.RssListAdapter
import kotlinx.android.synthetic.main.activity_main.recyclerView
import javax.inject.Inject

const val EXTRA_RSS: String = "extra_rss"

class MainActivity : BaseActivity(), MainView {

  @Inject
  lateinit var presenter: MainPresenter

  lateinit var adapter: RssListAdapter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    initView()
    presenter.viewReady()
  }

  private fun initView() {
    initToolbar(resources.getString(R.string.main_title_toolbar))
  }

  override fun displayList(list: List<Rss>) {
    adapter = RssListAdapter(list, listener = { rss -> onItemClicked(rss) })
    recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    recyclerView.adapter = adapter
  }

  private fun onItemClicked(rss: Rss) {
    presenter.clickItem(rss)
  }
}
