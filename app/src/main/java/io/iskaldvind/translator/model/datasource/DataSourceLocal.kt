package io.iskaldvind.translator.model.datasource

import io.iskaldvind.translator.model.data.AppState

interface DataSourceLocal<T> : DataSource<T> {

    suspend fun saveToDB(appState: AppState)
}
