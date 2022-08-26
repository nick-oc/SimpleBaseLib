package org.nick.master.library

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import java.lang.reflect.ParameterizedType

object InjectUtil {

    @JvmStatic
    fun <T> injectBinding(context: Context): T {
        val cls = (context.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<*>
        return cls.getMethod("inflate", LayoutInflater::class.java).invoke(null, LayoutInflater.from(context)) as T
    }

    @JvmStatic
    fun <T> injectBinding(context: Context, root: ViewGroup?, attachToRoot: Boolean): T {
        val cls = (context.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<*>
        return cls.getMethod("inflate", LayoutInflater::class.java, ViewGroup::class.java, Boolean::class.java)
            .invoke(null, LayoutInflater.from(context), root, attachToRoot) as T
    }
}