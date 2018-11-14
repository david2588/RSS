package com.david.rss.domain.repository

import com.david.rss.domain.Rss
import org.funktionale.either.Either

interface RSSRepository {

  fun getList(): Either<Exception, List<Rss>?>
}
