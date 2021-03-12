package com.ess.localsetting.utils

import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.util.DisplayMetrics

object ScreenTool {
    fun getScreenWidthPixels(mActivity: Activity): Int {
        val metric: DisplayMetrics = getScreenMetrics(mActivity)
        // 屏幕宽度（像素）
        return metric?.widthPixels
    }

    fun getScreenHeightPixels(mActivity: Activity): Int {
        val metric: DisplayMetrics = getScreenMetrics(mActivity)
        // 屏幕高度（像素）
        return metric.heightPixels
    }


    fun getScreenDPI(mActivity: Activity): Int {
        val metric: DisplayMetrics = getScreenMetrics(mActivity)
        return metric.densityDpi
    }

    private fun getScreenMetrics(mActivity: Activity): DisplayMetrics {
        return mActivity.resources.displayMetrics
    }
}