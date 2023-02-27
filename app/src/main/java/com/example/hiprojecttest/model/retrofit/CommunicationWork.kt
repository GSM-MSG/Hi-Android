package com.example.hiprojecttest.model.retrofit

import android.util.Log
import com.example.hiprojecttest.model.dto.auth.request.SignUpDTO
import com.example.hiprojecttest.model.dto.email.request.EmailSendDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Objects


class CommunicationWork {
    val emailService = RetrofitBuilder.emailService
    val authService = RetrofitBuilder.authService
    fun signUp(signUpInfo:SignUpDTO, successAction: () -> Unit){
        authService.signUp(signUpInfo)
            .enqueue(object : Callback<Unit>{
                override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                    val result = response.code()
                    Log.d("회원가입 성공","$result")
                    when(result){
                        201 -> {
                            Log.d("성공!!","$result")
                            successAction()
                        }
                    }
                }
                override fun onFailure(call: Call<Unit>, t: Throwable) {
                    Log.d("회원가입 실패",t.message.toString())
                }
            })

    }
    fun sendEamil(emailInfo: EmailSendDTO){
        emailService.sendEmail(emailInfo)
            .enqueue(object : Callback<Unit> {
                override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                    if (response.isSuccessful){
                        val result = response.body()
                        Log.d("email 전송 성공","$result")
                    }
                }

                override fun onFailure(call: Call<Unit>, t: Throwable) {
                    Log.d("email 전송 실패", t.message.toString())
                }
            })
    }

  suspend fun checkEmailCode(email: String, authKey: String, successAction: () -> Unit ){
        emailService.emailCheck(email, authKey)
        val code = emailService.emailCheck(email, authKey).code()
        Log.d("통신 성공","$code")
        when(code) {
            200 -> {
                Log.d("인증번호가 일치합니다", "$code")
                successAction()
            }
            400 -> Log.d("인증번호가 일치하지 않습니다","$code")
        }
    }
}