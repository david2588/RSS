package com.david.rss.common.di

import com.david.rss.detail.di.DetailModule
import com.david.rss.detail.view.DetailActivity
import com.david.rss.main.di.MainModule
import com.david.rss.main.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

  @ContributesAndroidInjector(modules = [(MainModule::class)])
  @PerActivity
  internal abstract fun bindMain(): MainActivity

  @ContributesAndroidInjector(modules = [(DetailModule::class)])
  @PerActivity
  internal abstract fun bindDetail(): DetailActivity
}
