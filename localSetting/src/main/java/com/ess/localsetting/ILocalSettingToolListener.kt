package com.ess.localsetting

import android.view.View

open interface ILocalSettingToolListener {
    fun onclickFirstDownload()
    fun onclickSysParSetting()
    fun onclickDeviceSetting()
    fun onclickCommonlySetting()
}