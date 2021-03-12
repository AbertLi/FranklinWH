package com.ess.localsetting

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.localseting.R

abstract class BaseActivity : AppCompatActivity(), IBackListener {
    companion object {
        private var TAG = "BaselActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        com.ess.localsetting.utils.statues.StatusBarUtil.setStatusBarColor(
            this,
            ContextCompat.getColor(this, R.color.title_bg_colors)
        )
        onCreateView()
    }

    abstract fun onCreateView()

    override fun back() {
        (this@BaseActivity).finish()
    }
}