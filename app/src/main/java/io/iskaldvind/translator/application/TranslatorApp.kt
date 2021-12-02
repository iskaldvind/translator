package io.iskaldvind.translator.application

import android.app.Application
import io.iskaldvind.translator.di.application
import io.iskaldvind.translator.di.historyScreen
import io.iskaldvind.translator.di.mainScreen
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TranslatorApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(listOf(application, mainScreen, historyScreen))
        }
    }
}
