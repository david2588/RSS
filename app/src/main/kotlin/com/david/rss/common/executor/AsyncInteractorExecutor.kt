package com.david.rss.common.executor

import com.david.rss.common.Interactor
import com.david.rss.common.InteractorExecutor
import com.david.rss.common.executor.runner.Runner

class AsyncInteractorExecutor(
    private val runOnUiThread: Runner,
    private val runOnBgThread: Runner
) : InteractorExecutor {

  override operator fun <Req, Res> invoke(
      interactor: Interactor<Req, Res>,
      request: Req,
      onError: (Throwable) -> Unit,
      onSuccess: (Res) -> Unit
  ) {
    runOnBgThread {
      val response = interactor(request)
      runOnUiThread {
        if (response.isRight()) {
          onSuccess(response.right().get())
        } else {
          onError(response.left().get())
        }
      }
    }
  }
}
