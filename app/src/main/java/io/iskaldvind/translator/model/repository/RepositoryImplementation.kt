package io.iskaldvind.translator.model.repository

import io.iskaldvind.translator.model.data.DataModel
import io.iskaldvind.translator.model.datasource.DataSource
import io.reactivex.Observable

class RepositoryImplementation(private val dataSource: DataSource<List<DataModel>>) :
    Repository<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return dataSource.getData(word)
    }
}
