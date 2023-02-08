package com.example.hiprojecttest.view


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.hiprojecttest.R


class SignUpActivity : AppCompatActivity() {
    lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)


        navController =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_email)!!.findNavController()

    }
}