package org.nick.master.library

import android.annotation.SuppressLint
import android.content.Context

class CrashHandler private constructor(val context: Context) : Thread.UncaughtExceptionHandler {

    init {
        Thread.setDefaultUncaughtExceptionHandler(this)
    }
    companion object {

        @SuppressLint("StaticFieldLeak")
        @JvmStatic
        lateinit var instance: CrashHandler

        fun attachContext(context: Context) {
            if (!::instance.isInitialized)
                instance = CrashHandler(context.applicationContext)
        }
    }

    override fun uncaughtException(t: Thread, e: Throwable) {

    }
}