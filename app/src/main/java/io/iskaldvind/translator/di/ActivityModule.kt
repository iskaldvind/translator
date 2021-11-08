package io.iskaldvind.translator.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.iskaldvind.translator.view.main.MainActivity

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}