package com.ess.localsetting

import android.content.Intent
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.ess.localsetting.utils.LogUtil
import com.ess.localsetting.utils.ScreenTool
import com.ess.localsetting.utils.StatusBarUtil
import com.example.localseting.R
import com.example.localseting.databinding.ActivityLocalSettingsToolBinding

class LocalSettingsToolActivity : BaseActivity(), ILocalSettingToolListener {
    companion object {
        private var TAG = "LocalSettingsToolActivity"
    }

    private var activityLocalSettingsToolBinding: ActivityLocalSettingsToolBinding? = null
    override fun onCreateView() {
        com.ess.localsetting.utils.statues.StatusBarUtil.setStatusBarColor(
            this,
            ContextCompat.getColor(this, R.color.title_bg_colors)
        )
        activityLocalSettingsToolBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_local_settings_tool)
        activityLocalSettingsToolBinding?.listener = this
        activityLocalSettingsToolBinding?.backListener = this
    }

    override fun onclickFirstDownload() {
        LogUtil.d(
            TAG,
            "onclickFirstDownload Status hight = ${StatusBarUtil.getStatusBarHeight(this)}"
        )
        LogUtil.d(TAG, "onclickFirstDownload Status dip = ${ScreenTool.getScreenDPI(this)}")
        LogUtil.d(
            TAG,
            "onclickFirstDownload Status width = ${ScreenTool.getScreenWidthPixels(this)}"
        )
        var intent = Intent(this, DeviceSettingsActivity::class.java)
        this.startActivity(intent)
    }

    override fun onclickSysParSetting() {
        LogUtil.d(TAG, "onclickFirstDownload")
    }

    override fun onclickDeviceSetting() {
        LogUtil.d(TAG, "onclickDeviceSetting")
    }

    override fun onclickCommonlySetting() {
        LogUtil.d(TAG, "onclickCommonlySetting")
    }
}