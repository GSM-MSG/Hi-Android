package com.example.hiprojecttest.view.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hiprojecttest.R
import com.example.hiprojecttest.databinding.ActivityLoginBinding
import com.example.hiprojecttest.model.dto.auth.request.LogInDTO
import com.example.hiprojecttest.model.retrofit.CommunicationWork
import com.example.hiprojecttest.setOnTextChanged
import com.example.hiprojecttest.view.MainActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.goBackButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.exit_to_right, R.anim.exit_to_right)
        }

        binding.passwordInputBox.setOnTextChanged { p0, _, _, _ ->
            if (!p0.isNullOrBlank()) {
                binding.nextStepBtn.background = resources.getDrawable(R.drawable.gradient_btn)
            }
        }

        binding.nextStepBtn.setOnClickListener {
            val logInData = LogInDTO(
                binding.emailInputBox.text.toString(),
                binding.passwordInputBox.text.toString()
            )
            val logInWork = CommunicationWork()
            logInWork.logIn(logInData)
        }
    }
}