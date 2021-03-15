package com.ess.localsetting

import androidx.databinding.DataBindingUtil
import com.ess.localsetting.clickinterface.ISysParSetingListener
import com.example.localseting.R
import com.example.localseting.databinding.ActivitySystemParSettingBinding

/**
 * 系统参数设置
 */
class SystemParSettingActivity : BaseActivity() {
    lateinit var binding: ActivitySystemParSettingBinding
    override fun onCreateView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_system_par_setting)
        binding.titleName = getString(R.string.sys_par_setting)
        binding.backListener = this
        binding.listener = listener
    }

    var listener = object :ISysParSetingListener{
        override fun localResPolicyClick() {
        }

        override fun resAdressPolicyClick() {
        }

        override fun sysParSettingClick() {
        }

    }
}