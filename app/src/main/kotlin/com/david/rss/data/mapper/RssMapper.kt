package com.david.rss.data.mapper

import com.david.rss.domain.Rss
import me.toptas.rssconverter.RssFeed

class RssMapper {

  fun map(rssFeed: RssFeed) =
      rssFeed.items?.asSequence()?.sortedByDescending { it.publishDate }?.map {
        Rss(
            description = it.description,
            image = it.image,
            link = it.link,
            publishDate = it.publishDate,
            title = it.title
        )
      }?.toList()
}
