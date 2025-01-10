package com.umc.phrase

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PhraseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}