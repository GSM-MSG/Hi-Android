package com.example.hiprojecttest.retrofit

import android.util.Log
import androidx.navigation.fragment.findNavController
import com.example.hiprojecttest.dto.email.request.EmailSendDTO
import com.example.hiprojecttest.view.fragment.EmailProveFragment
import com.example.hiprojecttest.view.fragment.EmailProveFragmentDirections
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CommunicationWork {
    fun sendEamil(emailInfo: EmailSendDTO){
        val service = RetrofitBuilder.signUpService

        service.sendEmail(emailInfo)
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

  suspend fun checkEmailCode(email: String, authKey: String){
        val service = RetrofitBuilder.signUpService

        service.emailCheck(email, authKey)
        val code = service.emailCheck(email, authKey).code()
        Log.d("통신 성공","$code")
        when(code) {
            200 -> {
                Log.d("인증번호가 일치합니다", "$code")
                val navigate = EmailProveFragment()
                val action = EmailProveFragmentDirections.actionEmailProveFragmentToMakingPassFragment()
                navigate.findNavController().navigate(action)
            }
            400 -> Log.d("인증번호가 일치하지 않습니다","$code")
        }
    }
}