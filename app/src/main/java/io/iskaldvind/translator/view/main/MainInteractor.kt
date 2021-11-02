package io.iskaldvind.translator.view.main

import io.iskaldvind.translator.presenter.Interactor
import io.iskaldvind.translator.model.data.AppState
import io.iskaldvind.translator.model.data.DataModel
import io.iskaldvind.translator.model.repository.Repository
import io.reactivex.Observable

class MainInteractor(
    private val remoteRepository: Repository<List<DataModel>>,
    private val localRepository: Repository<List<DataModel>>
) : Interactor<AppState> {

    override fun getData(word: String, fromRemoteSource: Boolean): Observable<AppState> {
        return if (fromRemoteSource) {
            remoteRepository.getData(word).map { AppState.Success(it) }
        } else {
            localRepository.getData(word).map { AppState.Success(it) }
        }
    }
}
