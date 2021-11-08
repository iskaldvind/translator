package io.iskaldvind.translator.presenter

import io.iskaldvind.translator.model.data.AppState
import io.iskaldvind.translator.view.base.View

interface Presenter<T : AppState, V : View> {

    fun attachView(view: V)

    fun detachView(view: V)

    fun getData(word: String, isOnline: Boolean)
}
