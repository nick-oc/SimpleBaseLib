package org.nick.master.library.utils

import android.content.Context
import android.content.res.Resources
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import androidx.viewbinding.ViewBinding
import org.nick.master.library.BuildConfig
import org.nick.master.library.utils.LogConfig.TAG_LOG
import org.nick.master.library.utils.LogConfig.logEnable

object LogConfig {
    const val TAG_LOG = "aaa -> "

    val isDebug = BuildConfig.DEBUG
    val logEnable = isDebug
}

inline fun <reified T : Any> T.llog(msg: String, tag: String = this::class.java.simpleName, e: Throwable? = null) {
    if (logEnable) Log.i(TAG_LOG + tag, msg, e)
}

inline fun <reified T : Any> T.llogi(msg: String, tag: String = this::class.java.simpleName, e: Throwable? = null) {
    Log.i(TAG_LOG + tag, msg, e)
}

inline fun <reified T : Any> T.llogd(msg: String, tag: String = this::class.java.simpleName, e: Throwable? = null) {
    Log.d(TAG_LOG + tag, msg, e)
}

inline fun <reified T : Any> T.lloge(msg: String = "", tag: String = this::class.java.simpleName, e: Throwable? = null) {
    Log.e(TAG_LOG + tag, msg, e)
}

inline fun <reified T : Any> T.llogw(msg: String = "", tag: String = this::class.java.simpleName, e: Throwable? = null) {
    Log.w(TAG_LOG + tag, msg, e)
}

inline fun <reified T : ViewBinding> T.inject(context: Context): T {
    val cls = this::class.java
    return cls.getMethod("inflate", LayoutInflater::class.java).invoke(null, LayoutInflater.from(context)) as T
}

fun View.show() {
    if (visibility != View.VISIBLE) visibility = View.VISIBLE
}

fun View.gone() {
    if (visibility != View.GONE) visibility = View.GONE
}

val Float.dp
    get() = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, Resources.getSystem().displayMetrics)

val Float.sp
    get() = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, this, Resources.getSystem().displayMetrics)

val Int.dp
    get() = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), Resources.getSystem().displayMetrics).toInt()

val Int.sp
    get() = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, this.toFloat(), Resources.getSystem().displayMetrics).toInt()