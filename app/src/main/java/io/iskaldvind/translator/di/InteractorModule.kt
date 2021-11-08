package io.iskaldvind.translator.di

import dagger.Module
import dagger.Provides
import io.iskaldvind.translator.model.data.DataModel
import io.iskaldvind.translator.model.repository.Repository
import io.iskaldvind.translator.view.main.MainInteractor
import javax.inject.Named

@Module
class InteractorModule {

    @Provides
    internal fun provideInteractor(
        @Named(NAME_REMOTE) repositoryRemote: Repository<List<DataModel>>,
        @Named(NAME_LOCAL) repositoryLocal: Repository<List<DataModel>>
    ) = MainInteractor(repositoryRemote, repositoryLocal)
}