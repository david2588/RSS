package com.david.rss.main.interactor

import com.david.rss.common.Interactor
import com.david.rss.domain.Rss
import com.david.rss.domain.repository.RSSRepository
import org.funktionale.either.Either
import javax.inject.Inject

class GetListInteractor @Inject constructor(
    private val rssRepository: RSSRepository
) :
    Interactor<Unit, GetListInteractor.Response> {

  data class Response(
      val rss: List<Rss>?)

  override fun invoke(request: Unit): Either<Throwable, Response> {
    val list = rssRepository.getList()

    return if (list.isRight()) {
      Either.right(
          Response(
              rss = if (list.isRight()) list.right().get() else null
          )
      )
    } else {
      Either.left(list.left().get())
    }
  }
}
