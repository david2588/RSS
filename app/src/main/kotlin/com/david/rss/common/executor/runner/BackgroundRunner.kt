package com.david.rss.common.executor.runner

import java.util.concurrent.Executors

class BackgroundRunner(
    private val executorService: java.util.concurrent.Executor = Executors.newSingleThreadExecutor()
) : Runner {

  override fun invoke(c: () -> Unit) = executorService.execute(c)
}
