package com.david.rss.main.presenter

import com.david.rss.common.InteractorExecutor
import com.david.rss.common.Router
import com.david.rss.common.weak
import com.david.rss.domain.Rss
import com.david.rss.main.interactor.GetListInteractor

class MainPresenter constructor(
    mainView: MainView,
    private val getListInteractor: GetListInteractor,
    private val execute: InteractorExecutor,
    private val router: Router
) {

  val view: MainView? by weak(mainView)

  fun viewReady() {
    execute(getListInteractor, Unit) { response ->
      view?.let { view ->
        response.rss?.let { view.displayList(it) }
      }
    }
  }

  fun clickItem(rss: Rss) {
    router.navigateToDetail(rss)
  }
}
