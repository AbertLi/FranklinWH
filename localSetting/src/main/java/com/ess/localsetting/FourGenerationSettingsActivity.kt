package com.ess.localsetting

import androidx.databinding.DataBindingUtil
import com.ess.localsetting.clickinterface.IEnterListener
import com.ess.localsetting.utils.LogUtil
import com.example.localseting.R
import com.example.localseting.databinding.ActivityFourGBinding


class FourGenerationSettingsActivity : BaseActivity() {
    private val TAG = "FourGActivity"
    private lateinit var dataBinding:ActivityFourGBinding
    override fun onCreateView() {
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_four_g)
        dataBinding.backListener = this
        dataBinding.titleName = getString(R.string.fourg)
        dataBinding.enterListener = enterListener
    }

    var enterListener = object :IEnterListener{
        override fun enter() {
            LogUtil.d(TAG,"enter value = ${dataBinding.edInputMac.text?.toString()}")
        }
    }
}