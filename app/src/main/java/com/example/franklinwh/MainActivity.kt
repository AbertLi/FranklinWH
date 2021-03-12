package com.example.franklinwh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ess.localsetting.LocalSettingsToolActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var intent = Intent(this, LocalSettingsToolActivity::class.java)
        startActivity(intent)
    }

    override fun onRestart() {
        super.onRestart()
        finish()
    }
}