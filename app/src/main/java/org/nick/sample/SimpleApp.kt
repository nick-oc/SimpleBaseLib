package org.nick.sample

import android.app.Application
import org.nick.master.library.utils.LogConfig

class SimpleApp : Application() {
    override fun onCreate() {
        super.onCreate()
        LogConfig.logEnable = true
    }
}