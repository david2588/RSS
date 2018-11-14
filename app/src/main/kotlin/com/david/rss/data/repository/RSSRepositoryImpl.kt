package com.david.rss.data.repository

import com.david.rss.data.api.RssApiClient
import com.david.rss.data.mapper.RssMapper
import com.david.rss.domain.Rss
import com.david.rss.domain.repository.RSSRepository
import org.funktionale.either.Either
import javax.inject.Inject

class RSSRepositoryImpl @Inject constructor(
    private val apiClient: RssApiClient,
    private val rssMapper: RssMapper
) : RSSRepository {

  override fun getList(): Either<Exception, List<Rss>?> {
    val response = apiClient.getList()
    return if (response.isRight()) {
      val rss = rssMapper.map(response.right().get())
      Either.right(rss)
    } else {
      Either.left(response.left().get())
    }
  }
}
