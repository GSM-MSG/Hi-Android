package com.example.hiprojecttest.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hiprojecttest.R
import com.example.hiprojecttest.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.doLoginBtn.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.enter_from_right, R.anim.enter_from_right)
        }

        binding.doSignupBtn.setOnClickListener{

            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.enter_from_right, R.anim.enter_from_right)
        }
    }

}