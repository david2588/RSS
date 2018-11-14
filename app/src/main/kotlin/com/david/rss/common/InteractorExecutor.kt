package com.david.rss.common

interface InteractorExecutor {

  operator fun <TReq, TRes> invoke(
      interactor: Interactor<TReq, TRes>,
      request: TReq,
      onError: (Throwable) -> Unit = {},
      onSuccess: (TRes) -> Unit = {}
  )
}
