package com.ess.localsetting

import androidx.databinding.DataBindingUtil
import com.example.localseting.R
import com.example.localseting.databinding.ActivityHomeDeviceSettingsBinding

class BindingOrUnbundlingActivity : BaseActivity() {
    private var TAG = "BindingOrUnbundlingActivity"
    lateinit var dataBinding: ActivityHomeDeviceSettingsBinding
    override fun onCreateView() {
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_binding_or_unbundling)
        dataBinding.titleName = getString(R.string.device_setting)
    }


}