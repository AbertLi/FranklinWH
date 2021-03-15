package com.ess.localsetting

import android.view.View
import androidx.databinding.DataBindingUtil
import com.ess.localsetting.clickinterface.IAddListener
import com.example.localseting.R
import com.example.localseting.databinding.ActivityBindingOrUnbundlingBinding

class BindingOrUnbundlingActivity : BaseActivity() {
    private var TAG = "BindingOrUnbundlingActivity"
    lateinit var dataBinding: ActivityBindingOrUnbundlingBinding
    override fun onCreateView() {
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_binding_or_unbundling)
        dataBinding.titleName = getString(R.string.device_setting)
        dataBinding.addListener = addListener
        dataBinding.backListener = this
        dataBinding.date = "2021-03-14"
    }

    var addListener = object : IAddListener {
        override fun add() {
            dataBinding.tvRelatedAccount.visibility = View.VISIBLE
            dataBinding.edRelatedAccount.visibility = View.VISIBLE
            dataBinding.viewRelatedAccount.visibility = View.VISIBLE
        }
    }

}