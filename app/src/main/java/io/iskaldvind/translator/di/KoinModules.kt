package io.iskaldvind.translator.di

import androidx.room.Room
import io.iskaldvind.history.view.history.HistoryInteractor
import io.iskaldvind.history.view.history.HistoryViewModel
import io.iskaldvind.model.data.DataModel
import io.iskaldvind.model.room.HistoryDataBase
import io.iskaldvind.repository.*
import io.iskaldvind.translator.view.main.MainInteractor
import io.iskaldvind.translator.view.main.MainViewModel
import org.koin.dsl.module

val application = module {
    single { Room.databaseBuilder(get(), HistoryDataBase::class.java, "HistoryDB").build() }
    single { get<HistoryDataBase>().historyDao() }
    single<Repository<List<DataModel>>> { RepositoryImplementation(RetrofitImplementation()) }
    single<RepositoryLocal<List<DataModel>>> { RepositoryImplementationLocal(RoomDataBaseImplementation(get()))
    }
}

val mainScreen = module {
    factory { MainViewModel(get()) }
    factory { MainInteractor(get(), get()) }
}

val historyScreen = module {
    factory { HistoryViewModel(get()) }
    factory { HistoryInteractor(get(), get()) }
}
