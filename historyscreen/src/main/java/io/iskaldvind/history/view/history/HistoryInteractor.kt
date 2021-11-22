package io.iskaldvind.history.view.history

import io.iskaldvind.core.viewmodel.Interactor
import io.iskaldvind.history.mapSearchResultToResult
import io.iskaldvind.model.data.AppState
import io.iskaldvind.model.data.dto.SearchResultDto
import io.iskaldvind.repository.Repository
import io.iskaldvind.repository.RepositoryLocal

class HistoryInteractor(
    private val repositoryRemote: Repository<List<SearchResultDto>>,
    private val repositoryLocal: RepositoryLocal<List<SearchResultDto>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        return AppState.Success(
            mapSearchResultToResult(
                if (fromRemoteSource) {
                    repositoryRemote
                } else {
                    repositoryLocal
                }.getData(word)
            )
        )
    }
}
