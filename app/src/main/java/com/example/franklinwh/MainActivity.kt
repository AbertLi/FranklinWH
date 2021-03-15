package com.example.franklinwh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.ess.localsetting.LocalSettingsToolActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btn_go2local_setting).setOnClickListener {
            var intent = Intent(this, LocalSettingsToolActivity::class.java)
            startActivity(intent)
        }
    }
}