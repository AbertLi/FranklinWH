package com.ess.localsetting.utils.statues

import android.content.Context

/**
 * dp、sp转换为px的工具类
 */
object DisplayUtil {
    /**
     * 将px值转换为dip或dp值，保证尺寸大小不变
     * @param context
     * @param pxValue
     * @return
     */
    fun px2dip(context: Context, pxValue: Float): Int {
        val scale: Float = context.getResources().getDisplayMetrics().density
        return (pxValue / scale + 0.5f).toInt()
    }

    /**
     * 将dip或dp值转换为px值，保证尺寸不变
     * @param context
     * @param dipValue
     * @return
     */
    fun dip2px(context: Context, dipValue: Float): Int {
        val scale: Float = context.getResources().getDisplayMetrics().density
        return (dipValue * scale + 0.5f).toInt()
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     * @param context
     * @param pxValue
     * @return
     */
    fun px2sp(context: Context, pxValue: Float): Int {
        val fontScale: Float = context.getResources().getDisplayMetrics().scaledDensity
        return (pxValue / fontScale + 0.5f).toInt()
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     * @param context
     * @param spValue
     * @return
     */
    fun sp2px(context: Context, spValue: Float): Int {
        val fontScale: Float = context.getResources().getDisplayMetrics().scaledDensity
        return (spValue * fontScale + 0.5f).toInt()
    }
}