package io.iskaldvind.translator.di

import androidx.room.Room
import io.iskaldvind.history.view.history.HistoryActivity
import io.iskaldvind.history.view.history.HistoryInteractor
import io.iskaldvind.history.view.history.HistoryViewModel
import io.iskaldvind.model.data.dto.SearchResultDto
import io.iskaldvind.model.room.HistoryDataBase
import io.iskaldvind.repository.*
import io.iskaldvind.translator.view.main.MainActivity
import io.iskaldvind.translator.view.main.MainInteractor
import io.iskaldvind.translator.view.main.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val application = module {
    single { Room.databaseBuilder(get(), HistoryDataBase::class.java, "HistoryDB").build() }
    single { get<HistoryDataBase>().historyDao() }
    single<Repository<List<SearchResultDto>>> { RepositoryImplementation(RetrofitImplementation()) }
    single<RepositoryLocal<List<SearchResultDto>>> {
        RepositoryImplementationLocal(RoomDataBaseImplementation(get()))
    }
}

val mainScreen = module {
    scope(named<MainActivity>()) {
        scoped { MainInteractor(get(), get()) }
        viewModel { MainViewModel(get()) }
    }
}

val historyScreen = module {
    scope(named<HistoryActivity>()) {
        scoped { HistoryInteractor(get(), get()) }
        viewModel { HistoryViewModel(get()) }
    }
}
