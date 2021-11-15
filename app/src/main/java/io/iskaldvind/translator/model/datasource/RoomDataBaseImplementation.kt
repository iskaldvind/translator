package io.iskaldvind.translator.model.datasource

import io.iskaldvind.translator.model.data.AppState
import io.iskaldvind.translator.model.data.DataModel
import io.iskaldvind.translator.room.HistoryDao
import io.iskaldvind.translator.utils.convertDataModelSuccessToEntity
import io.iskaldvind.translator.utils.mapHistoryEntityToSearchResult

class RoomDataBaseImplementation(private val historyDao: HistoryDao) :
    DataSourceLocal<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return mapHistoryEntityToSearchResult(historyDao.all())
    }

    override suspend fun saveToDB(appState: AppState) {
        convertDataModelSuccessToEntity(appState)?.let {
            historyDao.insert(it)
        }
    }
}
