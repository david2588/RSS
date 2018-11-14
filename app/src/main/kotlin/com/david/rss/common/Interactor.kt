package com.david.rss.common

import org.funktionale.either.Either

interface Interactor<TReq, TRes> {
  operator fun invoke(request: TReq): Either<Throwable, TRes>
}
