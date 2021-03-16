package com.ess.localsetting

import android.content.Context
import android.graphics.Rect
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ess.localsetting.clickinterface.IAddListener
import com.ess.localsetting.clickinterface.IEnterListener
import com.ess.localsetting.clickinterface.ItemOnclickListener
import com.ess.localsetting.utils.LogUtil
import com.ess.localsetting.utils.statues.DisplayUtil
import com.example.localseting.R
import com.example.localseting.databinding.ActivityNetworkPortSettingBinding

class NetworkPortSettingActivity : BaseActivity() {
    companion object {
        private var TAG = "NetworkPortSettingActivity"
    }

    lateinit var binding: ActivityNetworkPortSettingBinding
    override fun onCreateView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_network_port_setting)
        binding.backListener = this
        binding.enterListener = enterListener
        binding.addListener = addListener
        binding.titleName = getString(R.string.network_port_par_setting)

        var adapter = PortParSettingsAdapter(this, getDatas())
        binding.rvNetworkPort.adapter = adapter
        binding.rvNetworkPort.layoutManager = GridLayoutManager(this, 2)
        binding.rvNetworkPort.addItemDecoration(
            NetworkPortParSettingItemDecoration(
                DisplayUtil.dip2px(this, 15F),
                DisplayUtil.dip2px(this, 5F),
                DisplayUtil.dip2px(this, 9F)
            )
        )
    }

    var enterListener = object : IEnterListener {
        override fun enter() {
        }
    }

    var addListener = object : IAddListener {
        override fun add() {
        }
    }

    fun getDatas(): ArrayList<ParInfo> {
        var datas = ArrayList<ParInfo>()
        datas.add(ParInfo("", R.mipmap.network_port_par, getString(R.string.gateway_ip), 1))
        datas.add(ParInfo("", R.mipmap.network_port_par, getString(R.string.subnet_mask_ip), 2))
        datas.add(ParInfo("", R.mipmap.network_port_par, getString(R.string.gateway), 3))
        datas.add(ParInfo("", R.mipmap.network_port_par, getString(R.string.iccid_code), 4))
        datas.add(ParInfo("", R.mipmap.network_port_par, getString(R.string.imsi_code), 5))
        return datas
    }

    class PortParSettingsAdapter(con: Context, data: ArrayList<ParInfo>) :
        RecyclerView.Adapter<PortParSettingsHolder>() {
        var context = con
        var nets: List<ParInfo>? = data
        var mClickListener: ItemOnclickListener<ParInfo>? = null


        fun setClickListeners(onclickListener: ItemOnclickListener<ParInfo>?) {
            this.mClickListener = onclickListener
        }

        fun setData(list: List<ParInfo>) {
            this.nets = list
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PortParSettingsHolder {
            var view = LayoutInflater.from(parent.context)
                .inflate(R.layout.network_port_settings_item, parent, false);
            return PortParSettingsHolder(view)
        }

        override fun onBindViewHolder(holder: PortParSettingsHolder, position: Int) {
            var itemData = nets?.get(position)
            holder.netName.text = itemData?.name
            holder.ivIcon.setImageResource(itemData?.icon ?: R.mipmap.network_port_par)
            holder.rootView.setOnClickListener {
                mClickListener?.onClick(nets?.get(position))
            }
            holder.edInputValue.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    LogUtil.d(TAG, "afterTextChanged = $s")
                    nets?.get(position)?.inputValue = s.toString()
                }

                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    LogUtil.d(TAG, "beforeTextChanged = $s")
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    LogUtil.d(TAG, "onTextChanged = $s")
                }
            })
        }

        override fun getItemCount(): Int {
            return nets?.size ?: 0
        }
    }

    data class ParInfo(var inputValue: String, var icon: Int, var name: String, var position: Int)

    class PortParSettingsHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var rootView = itemView.findViewById<LinearLayout>(R.id.rootView)
        var netName = itemView.findViewById<TextView>(R.id.tv_item_name)
        var edInputValue = itemView.findViewById<EditText>(R.id.ed_input_num)
        var ivIcon = itemView.findViewById<ImageView>(R.id.iv_icon)
    }

    class NetworkPortParSettingItemDecoration(
        var singleLeftAnddoubleRight: Int,
        var singleRightAnddoubleLeft: Int,
        var upAndDown: Int
    ) :
        RecyclerView.ItemDecoration() {

        override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
        ) {
            if (parent.getChildAdapterPosition(view) % 2 != 0){
                outRect.right = singleLeftAnddoubleRight
                outRect.left = singleRightAnddoubleLeft
            }else{//单数item
                outRect.left = singleLeftAnddoubleRight
                outRect.right = singleRightAnddoubleLeft
            }
            outRect.bottom = upAndDown
            outRect.top = upAndDown

        }
    }
}