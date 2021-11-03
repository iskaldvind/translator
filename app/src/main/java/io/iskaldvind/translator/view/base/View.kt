package io.iskaldvind.translator.view.base

import io.iskaldvind.translator.model.data.AppState

interface View {

    fun renderData(appState: AppState)

}
