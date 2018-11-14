package com.david.rss.detail.di

import com.david.rss.common.Router
import com.david.rss.common.RouterImpl
import com.david.rss.common.di.PerActivity
import com.david.rss.detail.presenter.DetailPresenter
import com.david.rss.detail.view.DetailActivity
import com.david.rss.domain.Rss
import com.david.rss.main.view.EXTRA_RSS
import dagger.Module
import dagger.Provides

@Module
class DetailModule {

  @Provides
  @PerActivity
  fun provideRouter(activity: DetailActivity): Router {
    return RouterImpl(activity)
  }

  @Provides
  @PerActivity
  fun providePresenter(
      activity: DetailActivity,
      router: Router
  ): DetailPresenter {
    val rss = activity.intent.getParcelableExtra(EXTRA_RSS) as Rss
    return DetailPresenter(activity, router, rss)
  }
}