package com.david.rss.common.di

import android.app.Application
import com.david.rss.RSSApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class,
      AppModule::class,
      ActivityBuilder::class]
)
interface AppComponent : AndroidInjector<RSSApp> {

  override fun inject(app: RSSApp)

  @Component.Builder
  interface Builder {
    @BindsInstance
    fun application(application: Application): Builder

    fun build(): AppComponent
  }
}
