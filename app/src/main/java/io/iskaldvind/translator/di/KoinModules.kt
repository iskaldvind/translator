package io.iskaldvind.translator.di

import androidx.room.Room
import io.iskaldvind.translator.model.data.DataModel
import io.iskaldvind.translator.model.datasource.RetrofitImplementation
import io.iskaldvind.translator.model.datasource.RoomDataBaseImplementation
import io.iskaldvind.translator.model.repository.Repository
import io.iskaldvind.translator.model.repository.RepositoryImplementation
import io.iskaldvind.translator.room.HistoryDataBase
import io.iskaldvind.translator.view.main.MainActivityViewModel
import io.iskaldvind.translator.view.main.MainInteractor
import org.koin.core.qualifier.named
import org.koin.dsl.module

val application = module {
    single { Room.databaseBuilder(get(), HistoryDataBase::class.java, "HistoryDB").build() }
    single { get<HistoryDataBase>().historyDao() }
    single<Repository<List<DataModel>>>(named(NAME_REMOTE)) { RepositoryImplementation(
        RetrofitImplementation()
    ) }
    single<Repository<List<DataModel>>>(named(NAME_LOCAL)) { RepositoryImplementation(
        RoomDataBaseImplementation(get())
    ) }
}

val mainScreen = module {
    factory { MainInteractor(get(named(NAME_REMOTE)), get(named(NAME_LOCAL))) }
    factory { MainActivityViewModel(get()) }
}