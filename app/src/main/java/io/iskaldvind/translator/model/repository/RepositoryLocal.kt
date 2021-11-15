package io.iskaldvind.translator.model.repository

import io.iskaldvind.translator.model.data.AppState

interface RepositoryLocal<T> : Repository<T> {

    suspend fun saveToDB(appState: AppState)
}