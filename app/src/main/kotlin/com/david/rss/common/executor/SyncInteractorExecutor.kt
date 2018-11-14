package com.david.rss.common.executor

import com.david.rss.common.Interactor
import com.david.rss.common.InteractorExecutor

class SyncInteractorExecutor : InteractorExecutor {

  override operator fun <TReq, TRes> invoke(
      interactor: Interactor<TReq, TRes>,
      request: TReq,
      onError: (Throwable) -> Unit,
      onSuccess: (TRes) -> Unit
  ) {
    val response = interactor(request)
    if (response.isRight()) {
      onSuccess(response.right().get())
    } else {
      onError(response.left().get())
    }
  }
}
