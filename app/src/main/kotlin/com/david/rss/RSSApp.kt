package com.david.rss

import com.david.rss.common.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class RSSApp : DaggerApplication() {

  override fun onCreate() {
    super.onCreate()
  }

  override fun applicationInjector(): AndroidInjector<RSSApp> {
    val component = DaggerAppComponent.builder().application(this).build()
    component.inject(this)
    return component
  }
}
