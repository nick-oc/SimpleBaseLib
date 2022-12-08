package org.nick.master.library.utils

import android.content.Context
import android.view.View

object Utility {

    @JvmStatic
    fun getStatusBarHeight(context: Context): Int {
        val resourceId: Int = context.resources.getIdentifier("status_bar_height", "dimen", "android")
        return context.resources.getDimensionPixelSize(resourceId)
    }

    @JvmStatic
    fun fullWithStatusBar(context: Context, topView: View) {
        val height = getStatusBarHeight(context)
        topView.setPadding(0, height, 0, 0)
    }

}