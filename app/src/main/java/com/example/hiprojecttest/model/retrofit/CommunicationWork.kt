package com.example.hiprojecttest.model.retrofit

import android.content.Context
import android.util.Log
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.hiprojecttest.R
import com.example.hiprojecttest.model.dto.email.request.EmailSendDTO
import com.example.hiprojecttest.view.fragment.EmailFragment
import com.example.hiprojecttest.view.fragment.EmailProveFragment
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

    fun checkEmailCode(email: String,authKey: String){
        val service = RetrofitBuilder.signUpService

        service.emailCheck(email, authKey)
            .enqueue(object : Callback<Unit> {
                override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                    val result = response.body()
                    Log.d("email 인증 성공", "$result")
                }

                override fun onFailure(call: Call<Unit>, t: Throwable) {
                    Log.d("email 인증 실패", t.message.toString())
                }

            })
    }
}