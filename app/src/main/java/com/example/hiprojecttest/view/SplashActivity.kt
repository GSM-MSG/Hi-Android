package com.example.hiprojecttest.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.hiprojecttest.R
import com.example.hiprojecttest.view.notice.NoticeActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

       Handler().postDelayed({
           val intent = Intent(this, NoticeActivity::class.java)
           intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
           startActivity(intent)
       },3000)
    }
}