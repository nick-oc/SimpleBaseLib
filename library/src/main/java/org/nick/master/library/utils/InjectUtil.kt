package org.nick.master.library.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

object InjectUtil {
    @JvmStatic
    fun <T> injectBinding(generic: Type, context: Context): T {
        val cls = (generic as ParameterizedType).actualTypeArguments[0] as Class<T>
        return cls.getMethod("inflate", LayoutInflater::class.java).invoke(null, LayoutInflater.from(context)) as T
    }

    @JvmStatic
    fun <T> injectBinding(generic: Type, context: Context, root: ViewGroup?, attachToRoot: Boolean): T {
        val cls = (generic as ParameterizedType).actualTypeArguments[0] as Class<T>
        return cls.getMethod("inflate", LayoutInflater::class.java, ViewGroup::class.java, Boolean::class.java)
            .invoke(null, LayoutInflater.from(context), root, attachToRoot) as T
    }
}