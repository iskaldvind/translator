package io.iskaldvind.translator.view.main

import io.iskaldvind.translator.model.data.AppState
import io.iskaldvind.translator.model.data.DataModel
import io.iskaldvind.translator.model.repository.Repository
import io.iskaldvind.translator.model.repository.RepositoryLocal
import io.iskaldvind.translator.viewmodel.Interactor

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
