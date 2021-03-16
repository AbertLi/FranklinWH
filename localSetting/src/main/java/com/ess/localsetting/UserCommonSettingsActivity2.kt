package com.ess.localsetting

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ess.localsetting.clickinterface.IUserCommonSettingsListener
import com.ess.localsetting.clickinterface.ItemOnclickListener
import com.ess.localsetting.utils.LogUtil
import com.example.localseting.R
import com.example.localseting.databinding.ActivityUserCommonSettings2Binding


class UserCommonSettingsActivity2 : BaseActivity() {
    private var TAG = "UserCommonSettingsActivity2"
    lateinit var dataBinding: ActivityUserCommonSettings2Binding
    override fun onCreateView() {
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_user_common_settings2)
        dataBinding.titleName = getString(R.string.commonly_setting)
        dataBinding.backListener = this
        dataBinding.listener = listener
    }


    var listener = object : IUserCommonSettingsListener {
        override fun userCommentSettingClick() {

        }

        override fun autoPosClick() {

        }

        override fun mapPosClick() {

        }

        override fun manualInputClick() {

        }

        override fun netSettingsClick() {
            var context = this@UserCommonSettingsActivity2
            if (dataBinding.rvNetSetting.isVisible) {
                dataBinding.rvNetSetting.visibility = View.GONE
            } else {
                dataBinding.rvNetSetting.visibility = View.VISIBLE
                dataBinding.rvNetSetting.layoutManager = LinearLayoutManager(context)
                var data = ArrayList<NetInfo>()
                data.add(NetInfo(context.getString(R.string.network_port1), 0))
                data.add(NetInfo(context.getString(R.string.network_port2), 1))
                data.add(NetInfo(context.getString(R.string.wifi), 2))
                data.add(NetInfo(context.getString(R.string.fourg), 3))

                var adapter = NetSettingsAdapter(context, data)
                dataBinding.rvNetSetting.adapter = adapter
                adapter.setClickListeners(onclickListener)
            }
        }
    }

    var onclickListener = object : ItemOnclickListener<NetInfo>() {
        override fun onClick(itemBean: NetInfo?) {
            LogUtil.d(TAG, itemBean?.name ?: "NULL")
            when (itemBean?.position) {
                0 -> {
                    var intent = Intent(
                        this@UserCommonSettingsActivity2,
                        NetworkPortSettingActivity::class.java
                    )
                    startActivity(intent)
                }
                1 -> {
                    var intent = Intent(
                        this@UserCommonSettingsActivity2,
                        NetworkPortSettingActivity::class.java
                    )
                    startActivity(intent)
                }
                2 -> {
                    var intent =
                        Intent(this@UserCommonSettingsActivity2, WifiSettingsActivity::class.java)
                    startActivity(intent)
                }
                3 -> {
                    var intent = Intent(
                        this@UserCommonSettingsActivity2,
                        FourGenerationSettingsActivity::class.java
                    )
                    startActivity(intent)
                }
            }
        }
    }

    class NetSettingsAdapter(con: Context, data: ArrayList<NetInfo>) :
        RecyclerView.Adapter<NetSettingsHolder>() {
        var context = con
        var nets: List<NetInfo>? = data
        var mClickListener: ItemOnclickListener<NetInfo>? = null


        fun setClickListeners(onclickListener: ItemOnclickListener<NetInfo>?) {
            this.mClickListener = onclickListener
        }

        fun setData(list: List<NetInfo>) {
            this.nets = list
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NetSettingsHolder {
            var view = LayoutInflater.from(parent.context)
                .inflate(R.layout.user_comment_set_netset_item, parent, false);
            return NetSettingsHolder(view)
        }

        override fun onBindViewHolder(holder: NetSettingsHolder, position: Int) {
            holder.netName.text = nets?.get(position)?.name
            holder.rootView.setOnClickListener {
                mClickListener?.onClick(nets?.get(position))
            }
        }

        override fun getItemCount(): Int {
            return nets?.size ?: 0
        }
    }

    data class NetInfo(var name: String, var position: Int)

    class NetSettingsHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var rootView = itemView.findViewById<RelativeLayout>(R.id.rootView)
        var netName = itemView.findViewById<TextView>(R.id.tv_net_name)
    }
}