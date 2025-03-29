package dev.slav.client.android

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import timber.log.Timber.DebugTree

/**
 * Slav.Dev application.
 */
@HiltAndroidApp
class SlavDevApp : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(DebugTree())
    }
}
