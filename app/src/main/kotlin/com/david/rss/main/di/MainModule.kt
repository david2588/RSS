package com.david.rss.main.di

import com.david.rss.common.InteractorExecutor
import com.david.rss.common.Router
import com.david.rss.common.RouterImpl
import com.david.rss.common.di.PerActivity
import com.david.rss.data.api.RssApiClient
import com.david.rss.data.mapper.RssMapper
import com.david.rss.data.repository.RSSRepositoryImpl
import com.david.rss.domain.repository.RSSRepository
import com.david.rss.main.interactor.GetListInteractor
import com.david.rss.main.presenter.MainPresenter
import com.david.rss.main.view.MainActivity
import dagger.Module
import dagger.Provides

@Module
class MainModule {

  @Provides
  @PerActivity
  fun provideRouter(activity: MainActivity): Router {
    return RouterImpl(activity)
  }

  @PerActivity
  fun provideRSSRepository(apiClient: RssApiClient): RSSRepository {
    return RSSRepositoryImpl(apiClient, RssMapper())
  }

  @Provides
  @PerActivity
  fun providePresenter(
      activity: MainActivity,
      getListInteractor: GetListInteractor,
      execute: InteractorExecutor,
      router: Router
  ): MainPresenter {
    return MainPresenter(activity, getListInteractor, execute, router)
  }
}