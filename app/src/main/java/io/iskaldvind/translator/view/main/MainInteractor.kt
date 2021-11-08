package io.iskaldvind.translator.view.main

import io.iskaldvind.translator.di.NAME_LOCAL
import io.iskaldvind.translator.di.NAME_REMOTE
import io.iskaldvind.translator.presenter.Interactor
import io.iskaldvind.translator.model.data.AppState
import io.iskaldvind.translator.model.data.DataModel
import io.iskaldvind.translator.model.repository.Repository
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Named

class MainInteractor
@Inject constructor(
    @Named(NAME_REMOTE) val remoteRepository: Repository<List<DataModel>>,
    @Named(NAME_LOCAL) val localRepository: Repository<List<DataModel>>
) : Interactor<AppState> {

    override fun getData(word: String, fromRemoteSource: Boolean): Observable<AppState> {
        return if (fromRemoteSource) {
            remoteRepository.getData(word).map { AppState.Success(it) }
        } else {
            localRepository.getData(word).map { AppState.Success(it) }
        }
    }
}
