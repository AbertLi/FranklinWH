package com.ess.localsetting

import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.ess.localsetting.bean.WifiInfo
import com.ess.localsetting.clickinterface.ItemOnclickListener
import com.example.localseting.BR
import com.example.localseting.R
import com.example.localseting.databinding.ActivityWifiSettingsBinding

class WifiSettingsActivity : BaseActivity() {
    lateinit var binding: ActivityWifiSettingsBinding
    override fun onCreateView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_wifi_settings)
        binding.titleName = getString(R.string.wifi)
        binding.backListener = this
        var adapter = WifiAdapter(getDatas(), BR.wifiInfo, itemClick)
        binding.rvWifiList.adapter = adapter
        binding.rvWifiList.layoutManager = LinearLayoutManager(this)
//        adapter.setDatas(getDatas())
    }


    var itemClick = object : ItemOnclickListener<WifiInfo>() {
        override fun onClick(info: WifiInfo?) {
            binding.connectWifiInfo = info
            binding.notifyChange()
        }
    }

    fun getDatas(): ArrayList<WifiInfo> {
        var infos = ArrayList<WifiInfo>()
        var info =
            WifiInfo("FLWS_TP_link", WifiInfo.CONNECT)//getString(R.string.connect_suc)
        var info2 =
            WifiInfo("FLWS_TP_link2", WifiInfo.NOT_CONNECT)//getString(R.string.connect_suc)
        var info3 =
            WifiInfo("FLWS_TP_link2", WifiInfo.NOT_CONNECT)//getString(R.string.connect_suc)
        var info4 =
            WifiInfo("FLWS_TP_link2", WifiInfo.NOT_CONNECT)//getString(R.string.connect_suc)
        infos.add(info)
        infos.add(info)
        infos.add(info2)
        infos.add(info3)
        infos.add(info4)
        return infos
    }
}