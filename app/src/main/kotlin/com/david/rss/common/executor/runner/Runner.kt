package com.david.rss.common.executor.runner

interface Runner {

  operator fun invoke(c: () -> Unit)
}
