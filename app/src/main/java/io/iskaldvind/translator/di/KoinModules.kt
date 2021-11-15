package io.iskaldvind.translator.di

import androidx.room.Room
import io.iskaldvind.translator.model.data.DataModel
import io.iskaldvind.translator.model.datasource.RetrofitImplementation
import io.iskaldvind.translator.model.datasource.RoomDataBaseImplementation
import io.iskaldvind.translator.model.repository.Repository
import io.iskaldvind.translator.model.repository.RepositoryImplementation
import io.iskaldvind.translator.model.repository.RepositoryImplementationLocal
import io.iskaldvind.translator.model.repository.RepositoryLocal
import io.iskaldvind.translator.room.HistoryDataBase
import io.iskaldvind.translator.view.history.HistoryInteractor
import io.iskaldvind.translator.view.history.HistoryViewModel
import io.iskaldvind.translator.view.main.MainActivityViewModel
import io.iskaldvind.translator.view.main.MainInteractor
import org.koin.dsl.module

val application = module {
    single { Room.databaseBuilder(get(), HistoryDataBase::class.java, "HistoryDB").build() }
    single { get<HistoryDataBase>().historyDao() }
    single<Repository<List<DataModel>>> { RepositoryImplementation(RetrofitImplementation()) }
    single<RepositoryLocal<List<DataModel>>> { RepositoryImplementationLocal(RoomDataBaseImplementation(get()))
    }
}

val mainScreen = module {
    factory { MainActivityViewModel(get()) }
    factory { MainInteractor(get(), get()) }
}

val historyScreen = module {
    factory { HistoryViewModel(get()) }
    factory { HistoryInteractor(get(), get()) }
}