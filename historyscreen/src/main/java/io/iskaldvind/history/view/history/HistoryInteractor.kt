package io.iskaldvind.history.view.history

import io.iskaldvind.core.viewmodel.Interactor
import io.iskaldvind.model.data.AppState
import io.iskaldvind.model.data.DataModel
import io.iskaldvind.repository.Repository
import io.iskaldvind.repository.RepositoryLocal

class HistoryInteractor(
    private val repositoryRemote: Repository<List<DataModel>>,
    private val repositoryLocal: RepositoryLocal<List<DataModel>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        return AppState.Success(
            if (fromRemoteSource) {
                repositoryRemote
            } else {
                repositoryLocal
            }.getData(word)
        )
    }
}
