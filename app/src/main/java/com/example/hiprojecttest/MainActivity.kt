package com.example.hiprojecttest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hiprojecttest.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.logInButton.setOnClickListener{
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }

        binding.sinUpButton.setOnClickListener{
            val intent = Intent(this,SinUpActivity::class.java)
            startActivity(intent)
        }
    }

}