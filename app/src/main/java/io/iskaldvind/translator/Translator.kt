package io.iskaldvind.translator

import android.app.Application
import io.iskaldvind.translator.di.application
import io.iskaldvind.translator.di.mainScreen
import org.koin.core.context.startKoin

class Translator: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(application, mainScreen))
        }
    }
}