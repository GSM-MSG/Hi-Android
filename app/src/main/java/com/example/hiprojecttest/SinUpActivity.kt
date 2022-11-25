package com.example.hiprojecttest


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController


class SinUpActivity : AppCompatActivity() {
    lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sinup)

        navController =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_email)!!.findNavController()

    }
}