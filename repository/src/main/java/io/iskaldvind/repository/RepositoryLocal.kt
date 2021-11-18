package io.iskaldvind.repository

import io.iskaldvind.model.data.AppState

interface RepositoryLocal<T> : Repository<T> {

    suspend fun saveToDB(appState: AppState)
}
