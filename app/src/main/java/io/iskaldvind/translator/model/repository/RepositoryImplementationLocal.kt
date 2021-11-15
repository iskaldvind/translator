package io.iskaldvind.translator.model.repository

import io.iskaldvind.translator.model.data.AppState
import io.iskaldvind.translator.model.data.DataModel
import io.iskaldvind.translator.model.datasource.DataSourceLocal

class RepositoryImplementationLocal(private val dataSource: DataSourceLocal<List<DataModel>>) :
    RepositoryLocal<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return dataSource.getData(word)
    }

    override suspend fun saveToDB(appState: AppState) {
        dataSource.saveToDB(appState)
    }
}