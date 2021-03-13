package com.ess.localsetting

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ess.localsetting.bean.DeviceInfo
import com.ess.localsetting.clickinterface.ItemOnclickListener
import com.example.localseting.R

class DeviceListAdapter(con: Context) : RecyclerView.Adapter<DeviceListAdapter.DeviceHolder>() {
    var context: Context? = con
    var devices: List<DeviceInfo>? = null
    var mClickListener: ItemOnclickListener<DeviceInfo>? = null


    fun setClickListeners(onclickListener: ItemOnclickListener<DeviceInfo>?) {
        this.mClickListener = onclickListener
    }

    fun setData(list: List<DeviceInfo>) {
        this.devices = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeviceHolder {
        var view = View.inflate(context, R.layout.device_setting_item, null)
        return DeviceHolder(view)
    }

    override fun onBindViewHolder(holder: DeviceHolder, position: Int) {
        holder.textView.text = devices?.get(position)?.name
        holder.rootView.setOnClickListener{
            mClickListener?.onClick(devices?.get(position))
        }
    }

    override fun getItemCount(): Int {
        return devices?.size ?: 0
    }

    class DeviceHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var rootView = itemView
        var textView = itemView.findViewById<TextView>(R.id.tv_device_name)
        var roundDot = itemView.findViewById<View>(R.id.round_dot)
        var ivConnectStatue = itemView.findViewById<ImageView>(R.id.iv_connect_statue)
    }
}