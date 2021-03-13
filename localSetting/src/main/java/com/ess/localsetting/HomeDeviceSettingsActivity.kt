package com.ess.localsetting

import android.content.Intent
import androidx.databinding.DataBindingUtil
import com.ess.localsetting.clickinterface.IHomeDeviceSettingsListener
import com.ess.localsetting.utils.LogUtil
import com.example.localseting.R
import com.example.localseting.databinding.ActivityHomeDeviceSettingsBinding

class HomeDeviceSettingsActivity : BaseActivity(),
    IHomeDeviceSettingsListener {
    private var TAG = "HomeDeviceSettingsActivity"
    lateinit var dataBinding: ActivityHomeDeviceSettingsBinding
    override fun onCreateView() {
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_home_device_settings)
        dataBinding.titleName = getString(R.string.device_setting)
        dataBinding.listener = this
        dataBinding.backListener = this
    }

    override fun infiniteAutoEdit() {
        LogUtil.d(TAG, "infiniteAutoEdit")
        var intent = Intent(this, DeviceInfiniteSettingsActivity::class.java)
        this.startActivity(intent)
    }

    override fun bindDevice() {
        LogUtil.d(TAG, "bindDevice")
        var intent = Intent(this, BindingOrUnbundlingActivity::class.java)
        this.startActivity(intent)
    }
}