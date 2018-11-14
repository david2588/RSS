package com.david.rss.main.view

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.view.Menu
import android.widget.SearchView
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
    adapter = RssListAdapter(list.toMutableList(), listener = { rss -> onItemClicked(rss) })
    recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    recyclerView.adapter = adapter
  }

  override fun updateList(list: List<Rss>) {
    adapter.items.clear()
    adapter.items.addAll(list)
    adapter.notifyDataSetChanged()
  }

  private fun onItemClicked(rss: Rss) {
    presenter.clickItem(rss)
  }

  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    menuInflater.inflate(R.menu.main, menu)

    val searchItem = menu.findItem(R.id.search)
    val searchView = searchItem.actionView as SearchView

    searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
      override fun onQueryTextSubmit(query: String): Boolean {
        return false
      }

      override fun onQueryTextChange(query: String): Boolean {
        presenter.sortList(query)
        return false
      }
    })

    return true
  }

}
