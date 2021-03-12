package com.ess.localsetting.utils

import android.content.Context
import android.content.res.Resources
import java.lang.reflect.Field

object StatusBarUtil {
    fun getStatusBarHeight(context: Context): Int {
        var statusBarHeight = getStatusBarHeightFromRes(context)
        return if (statusBarHeight != 0) statusBarHeight else getStatusBarHeightFromreFlection(
            context
        )
    }

    /**
     * 获取状态栏高度
     * @param context
     * @return
     */
    private fun getStatusBarHeightFromRes(context: Context): Int {
        val resources: Resources = context.resources
        val resourceId: Int = resources.getIdentifier("status_bar_height", "dimen", "android")
        return resources.getDimensionPixelSize(resourceId)
    }

    /**
     * 获取手机状态栏高
     * @param context
     * @return
     */
    private fun getStatusBarHeightFromreFlection(context: Context): Int {
        var c: Class<*>? = null
        var obj: Any? = null
        var field: Field? = null
        var x = 0
        var statusBarHeight = 0
        try {
            c = Class.forName("com.android.internal.R\$dimen")
            obj = c.newInstance()
            field = c.getField("status_bar_height")
            x = field.get(obj).toString().toInt()
            statusBarHeight = context.resources.getDimensionPixelSize(x)
        } catch (e1: Exception) {
            e1.printStackTrace()
        }
        return statusBarHeight
    }
}