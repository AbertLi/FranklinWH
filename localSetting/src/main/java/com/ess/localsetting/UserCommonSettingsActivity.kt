//package com.ess.localsetting
//
//import androidx.databinding.DataBindingUtil
//import com.ess.localsetting.clickinterface.IUserCommonSettingsListener
//import com.example.localseting.R
//import com.example.localseting.databinding.ActivityUserCommonSettingsBinding
//
//class UserCommonSettingsActivity : BaseActivity() {
//    lateinit var dataBinding: ActivityUserCommonSettingsBinding
//    override fun onCreateView() {
//        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_user_common_settings)
//        dataBinding.titleName = getString(R.string.commonly_setting)
//        dataBinding.backListener = this
//        dataBinding.listener = userCommonSettingsListener
//    }
//
//    var userCommonSettingsListener = object : IUserCommonSettingsListener {
//        override fun userCommentSettingClick() {
//
//        }
//    }
//}