package com.david.rss.common.di

import android.app.Application
import android.content.Context
import com.david.rss.data.mapper.RssMapper
import com.david.rss.data.repository.RSSRepositoryImpl
import com.david.rss.domain.repository.RSSRepository
import com.david.rss.main.BuildConfig
import com.david.rss.common.InteractorExecutor
import com.david.rss.common.executor.AsyncInteractorExecutor
import com.david.rss.common.executor.runner.BackgroundRunner
import com.david.rss.data.api.RssApiClient
import com.david.rss.common.executor.runner.UiRunner
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

  @Provides
  @Singleton
  fun provideContext(application: Application): Context {
    return application
  }

  @Provides
  @Singleton
  fun provideApiClient(context: Context): RssApiClient {
    return RssApiClient(BuildConfig.API_URL)
  }

  @Provides
  @Singleton
  fun provideInteractorExecutor(): InteractorExecutor {
    return AsyncInteractorExecutor(UiRunner(), BackgroundRunner())
  }

  @Provides
  @Singleton
  fun provideRssRepository(apiClient: RssApiClient): RSSRepository {
    return RSSRepositoryImpl(apiClient, RssMapper())
  }
}
