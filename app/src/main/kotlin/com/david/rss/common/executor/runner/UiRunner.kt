package com.david.rss.common.executor.runner

import android.os.Handler
import android.os.Looper
import com.david.rss.common.executor.runner.Runner

class UiRunner(private val handler: Handler = Handler(Looper.getMainLooper())) : Runner {

  override fun invoke(c: () -> Unit) {
    handler.post(c)
  }
}
