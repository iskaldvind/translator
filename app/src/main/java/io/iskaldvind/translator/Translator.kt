package io.iskaldvind.translator

import android.app.Application
import io.iskaldvind.translator.di.application
import io.iskaldvind.translator.di.historyScreen
import io.iskaldvind.translator.di.mainScreen
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Translator: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(listOf(application, mainScreen, historyScreen))
        }
    }
}