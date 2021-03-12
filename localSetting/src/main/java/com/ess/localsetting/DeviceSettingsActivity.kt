package com.ess.localsetting

import android.annotation.SuppressLint
import android.widget.Adapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.ess.localsetting.bean.DeviceInfo
import com.ess.localsetting.utils.LogUtil
import com.example.localseting.R
import com.example.localseting.databinding.ActivityDeviceSettingsBinding

class DeviceSettingsActivity : BaseActivity(), IDeviceSettingsListener {
    companion object {
        private const val TAG = "DeviceSettingsActivity"
    }

    private lateinit var binding: ActivityDeviceSettingsBinding
    lateinit var adapter:DeviceListAdapter

    @SuppressLint("ResourceType")
    override fun onCreateView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_device_settings)
        binding?.titleName = this.getString(R.string.device_setting)
        binding.backListener = this
        adapter = DeviceListAdapter(this)
        adapter.mClickListener = DeviceItemOnclickListener()
        binding.rvDeviceList.adapter = adapter
        binding.rvDeviceList.layoutManager = LinearLayoutManager(this)
        binding.listener = this
    }

    class DeviceItemOnclickListener : ItemOnclickListener<DeviceInfo>() {
        override fun onClick(info: DeviceInfo?) {
        }
    }

    override fun enter() {
        binding.edInputNum.text?.let {
            adapter.setData(getData(it?.toString()?.toInt()?:10))
        }
    }

    override fun enter2() {
        LogUtil.d(TAG,"enter2")

    }

    fun getData(num: Int): ArrayList<DeviceInfo> {
        var list = ArrayList<DeviceInfo>()
        for (i in 1..num) {
            var deviceInfo = DeviceInfo("设备$i", i)
            list.add(deviceInfo)
        }
        return list
    }
}