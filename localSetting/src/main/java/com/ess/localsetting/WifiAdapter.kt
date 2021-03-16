package com.ess.localsetting

import com.ess.localsetting.bean.WifiInfo
import com.ess.localsetting.clickinterface.ItemOnclickListener
import com.example.localseting.R
import com.example.localseting.databinding.WifiSettingItemBinding


class WifiAdapter(
    private val itemList: List<WifiInfo>?,
    private val brId: Int,
    private val clickListener: ItemOnclickListener<WifiInfo>
) : BaseAdapter<WifiInfo, WifiSettingItemBinding>(itemList, brId) {
    override fun getLayoutId(): Int {
        return R.layout.wifi_setting_item //item对应的layoutId
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        var itemData = itemList?.get(position)
        holder.binding.clRootView.setOnClickListener {
            clickListener.onClick(itemData)
        }
        holder.binding.tvWifiName.text = itemData?.name ?: ""
    }

    fun setDatas(itemList: List<WifiInfo>) {
        mItemList = itemList
        notifyDataSetChanged()
    }

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        return super.onCreateViewHolder(parent, viewType)
//    }
}


