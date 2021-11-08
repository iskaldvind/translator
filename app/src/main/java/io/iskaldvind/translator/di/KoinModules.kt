package io.iskaldvind.translator.di

import io.iskaldvind.translator.model.data.DataModel
import io.iskaldvind.translator.model.datasource.RetrofitImplementation
import io.iskaldvind.translator.model.datasource.RoomDataBaseImplementation
import io.iskaldvind.translator.model.repository.Repository
import io.iskaldvind.translator.model.repository.RepositoryImplementation
import io.iskaldvind.translator.view.main.MainActivityViewModel
import io.iskaldvind.translator.view.main.MainInteractor
import org.koin.core.qualifier.named
import org.koin.dsl.module

val application = module {
    single<Repository<List<DataModel>>>(named(NAME_REMOTE)) { RepositoryImplementation(
        RetrofitImplementation()
    ) }
    single<Repository<List<DataModel>>>(named(NAME_LOCAL)) { RepositoryImplementation(
        RoomDataBaseImplementation()
    ) }
}

val mainScreen = module {
    factory { MainInteractor(get(named(NAME_REMOTE)), get(named(NAME_LOCAL))) }
    factory { MainActivityViewModel(get()) }
}