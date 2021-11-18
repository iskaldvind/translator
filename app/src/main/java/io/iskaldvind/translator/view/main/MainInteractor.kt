package io.iskaldvind.translator.view.main

import io.iskaldvind.core.viewmodel.Interactor
import io.iskaldvind.model.data.AppState
import io.iskaldvind.model.data.DataModel
import io.iskaldvind.repository.Repository
import io.iskaldvind.repository.RepositoryLocal

class MainInteractor(
    private val repositoryRemote: Repository<List<DataModel>>,
    private val repositoryLocal: RepositoryLocal<List<DataModel>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        val appState: AppState
        if (fromRemoteSource) {
            appState = AppState.Success(repositoryRemote.getData(word))
            repositoryLocal.saveToDB(appState)
        } else {
            appState = AppState.Success(repositoryLocal.getData(word))
        }
        return appState
    }
}
