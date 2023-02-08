package com.example.hiprojecttest.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hiprojecttest.R
import com.example.hiprojecttest.databinding.ActivityLoginBinding
import com.example.hiprojecttest.setOnTextChanged

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var email = binding.emailInputBox.toString()
        var pass = binding.passwordInputBox.toString()
        binding.goBackButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.exit_to_right, R.anim.exit_to_right)
        }

        binding.passwordInputBox.setOnTextChanged { p0, p1, p2, p3 ->
            if (!p0.isNullOrBlank()){
                binding.nextStepBtn.setBackground(resources.getDrawable(R.drawable.gradient_btn))
            }
        }




    }
}