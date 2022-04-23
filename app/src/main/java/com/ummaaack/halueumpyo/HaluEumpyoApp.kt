package com.ummaaack.halueumpyo

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ummaaack.halueumpyo.data.HaluEumpyoRepository
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class HaluEumpyoApp : Application() {

    override fun onCreate() {
        super.onCreate()
        HaluEumpyoRepository.init(this)
        initLogger()
    }

    private fun initLogger() {
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }
}