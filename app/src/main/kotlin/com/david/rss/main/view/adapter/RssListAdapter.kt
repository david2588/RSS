package com.david.rss.main.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.david.rss.common.inflate
import com.david.rss.common.isAbsoluteUrl
import com.david.rss.common.load
import com.david.rss.common.loadHtml
import com.david.rss.domain.Rss
import com.david.rss.main.R
import kotlinx.android.synthetic.main.item_rss.view.dateTextview
import kotlinx.android.synthetic.main.item_rss.view.descriptionTextView
import kotlinx.android.synthetic.main.item_rss.view.imageImageView
import kotlinx.android.synthetic.main.item_rss.view.titleTextView
import kotlin.properties.Delegates

typealias Listener = (Rss) -> Unit

class RssListAdapter(listItem: MutableList<Rss>, private val listener: Listener)
  : RecyclerView.Adapter<RssListAdapter.ItemViewHolder>() {

  var items: MutableList<Rss> by Delegates.observable(listItem) { _, _, _ -> this.notifyDataSetChanged() }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
    val itemViewHolder = parent.inflate(R.layout.item_rss)
    return ItemViewHolder(itemViewHolder)
  }

  override fun getItemCount() = items.size

  override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
    holder.bind(items[position])
  }

  inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(rss: Rss) = with(itemView) {
      itemView.setOnClickListener { listener(rss) }

      titleTextView.loadHtml(rss.title)
      descriptionTextView.loadHtml(rss.description)

      dateTextview.text = rss.publishDate

      rss.image?.let {
        if (it.isAbsoluteUrl()) {
          imageImageView.visibility = View.VISIBLE
          imageImageView.load(it)
        }
      }
    }

  }
}


