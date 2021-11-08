package io.iskaldvind.translator.model.datasource

import io.iskaldvind.translator.model.data.DataModel
import io.reactivex.Observable

class RoomDataBaseImplementation : DataSource<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
