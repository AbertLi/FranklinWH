package com.ess.localsetting

import android.os.Bundle
import android.view.*
import androidx.annotation.LayoutRes
import androidx.annotation.StyleRes
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.ess.localsetting.utils.DisplayHelper
import com.example.localseting.R

/**
 * author : LPB
 * time   : 2021/03/18
 * desc   :
 */
class InputLocationBottomDialog : DialogFragment() {
    private var margin //左右边距
            = 0
    private var width //宽度
            = 0
    private var height //高度
            = 0
    private var dimAmount = 0.5f //灰度深浅
    private var showBottom = true //是否底部显示
    private var outCancel = true //是否点击外部取消

    @StyleRes
    private var animStyle = 0

    @LayoutRes
    protected var layoutId = 0

    //public abstract void convertView(ViewHolder holder, MyBaseDialogFragment dialog);
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.NiceDialog)

        //恢复保存的数据
        if (savedInstanceState != null) {
            margin = savedInstanceState.getInt(MARGIN)
            width = savedInstanceState.getInt(WIDTH)
            height = savedInstanceState.getInt(HEIGHT)
            dimAmount = savedInstanceState.getFloat(DIM)
            showBottom = savedInstanceState.getBoolean(BOTTOM)
            outCancel = savedInstanceState.getBoolean(CANCEL)
            animStyle = savedInstanceState.getInt(ANIM)
            layoutId = savedInstanceState.getInt(LAYOUT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.input_location_dialog_layout, container, true)
    }

    override fun onStart() {
        super.onStart()
        initParams()
    }

    /**
     * 屏幕旋转等导致DialogFragment销毁后重建时保存数据
     *
     * @param outState
     */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(MARGIN, margin)
        outState.putInt(WIDTH, width)
        outState.putInt(HEIGHT, height)
        outState.putFloat(DIM, dimAmount)
        outState.putBoolean(BOTTOM, showBottom)
        outState.putBoolean(CANCEL, outCancel)
        outState.putInt(ANIM, animStyle)
        outState.putInt(LAYOUT, layoutId)
    }

    private fun initParams() {
        val window = dialog?.window
        if (window != null) {
            val lp = window.attributes
            //调节灰色背景透明度[0-1]，默认0.5f
            lp.dimAmount = dimAmount
            //是否在底部显示
            if (showBottom) {
                lp.gravity = Gravity.BOTTOM
                if (animStyle == 0) {
                    animStyle = R.style.DefaultAnimation
                }
            }

            //设置dialog宽度
            if (width == 0) {
                lp.width = DisplayHelper.getScreenWidth(activity) - 2 * DisplayHelper.dp2px(
                    activity,
                    margin
                )
            } else {
                lp.width = DisplayHelper.dp2px(activity, width)
            }
            //设置dialog高度
            if (height == 0) {
                lp.height = WindowManager.LayoutParams.WRAP_CONTENT
            } else {
                lp.height = DisplayHelper.dp2px(activity, height)
            }

            //设置dialog进入、退出的动画
            window.setWindowAnimations(animStyle)
            window.attributes = lp
        }
        isCancelable = outCancel
    }

    fun setMargin(margin: Int): InputLocationBottomDialog {
        this.margin = margin
        return this
    }

    fun setWidth(width: Int): InputLocationBottomDialog {
        this.width = width
        return this
    }

    fun setHeight(height: Int): InputLocationBottomDialog {
        this.height = height
        return this
    }

    fun setDimAmount(dimAmount: Float): InputLocationBottomDialog {
        this.dimAmount = dimAmount
        return this
    }

    fun setShowBottom(showBottom: Boolean): InputLocationBottomDialog {
        this.showBottom = showBottom
        return this
    }

    fun setOutCancel(outCancel: Boolean): InputLocationBottomDialog {
        this.outCancel = outCancel
        return this
    }

    fun setAnimStyle(animStyle: Int): InputLocationBottomDialog {
        this.animStyle = animStyle
        return this
    }

    fun show(manager: FragmentManager?): InputLocationBottomDialog {
        super.show(manager!!, System.currentTimeMillis().toString())
        return this
    }

    companion object {
        private const val MARGIN = "margin"
        private const val WIDTH = "width"
        private const val HEIGHT = "height"
        private const val DIM = "dim_amount"
        private const val BOTTOM = "show_bottom"
        private const val CANCEL = "out_cancel"
        private const val ANIM = "anim_style"
        private const val LAYOUT = "layout_id"
    }
}