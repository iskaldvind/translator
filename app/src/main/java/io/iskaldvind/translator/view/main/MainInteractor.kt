package io.iskaldvind.translator.view.main

import io.iskaldvind.core.viewmodel.Interactor
import io.iskaldvind.model.data.AppState
import io.iskaldvind.model.data.dto.SearchResultDto
import io.iskaldvind.repository.Repository
import io.iskaldvind.repository.RepositoryLocal
import io.iskaldvind.translator.utils.mapSearchResultToResult

class MainInteractor(
    private val repositoryRemote: Repository<List<SearchResultDto>>,
    private val repositoryLocal: RepositoryLocal<List<SearchResultDto>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        val appState: AppState
        if (fromRemoteSource) {
            appState = AppState.Success(mapSearchResultToResult(repositoryRemote.getData(word)))
            repositoryLocal.saveToDB(appState)
        } else {
            appState = AppState.Success(mapSearchResultToResult(repositoryLocal.getData(word)))
        }
        return appState
    }
}
