package com.ess.localsetting

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.ess.localsetting.utils.LogUtil
import com.ess.localsetting.utils.ScreenTool
import com.ess.localsetting.utils.StatusBarUtil
import com.example.localseting.R
import com.example.localseting.databinding.ActivityLocalSettingsToolBinding

class LocalSettingsToolActivity : AppCompatActivity() {
    companion object {
        private var TAG = "LocalSettingsToolActivity"
        lateinit var context: Activity
    }

    private var activityLocalSettingsToolBinding: ActivityLocalSettingsToolBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        com.ess.localsetting.utils.statues.StatusBarUtil.setStatusBarColor(
            this,
            ContextCompat.getColor(this, R.color.title_colors)
        )
        context = this
        activityLocalSettingsToolBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_local_settings_tool)
        var listener = LocalSettingToolListener()
        activityLocalSettingsToolBinding?.listener = listener
        activityLocalSettingsToolBinding?.backListener = listener
        setView()
    }

    private fun setView() {

    }


    open class LocalSettingToolListener : ILocalSettingToolListener, IBackListener {
        override fun onclickFirstDownload() {
            LogUtil.d(
                TAG,
                "onclickFirstDownload Status hight = ${StatusBarUtil.getStatusBarHeight(context)}"
            )
            LogUtil.d(TAG, "onclickFirstDownload Status dip = ${ScreenTool.getScreenDPI(context)}")
            LogUtil.d(
                TAG,
                "onclickFirstDownload Status width = ${ScreenTool.getScreenWidthPixels(context)}"
            )
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

        override fun back() {
            context.finish()
        }

    }
}