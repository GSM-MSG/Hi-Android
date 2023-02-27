package com.example.hiprojecttest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignUpViewModel: ViewModel() {
    private val _emailDataRequest = MutableLiveData<String>()
    val emailDataRequest : LiveData<String> get() = _emailDataRequest

    fun emailDataRequest(email: String){
        _emailDataRequest.value = email
    }

    private val _nameDataRequest = MutableLiveData<String>()
    val nameDataRequest: LiveData<String> get() = _emailDataRequest

    fun nameDataRequest(name: String){
        _nameDataRequest.value = name
    }

    private val _studentIdDataRequest = MutableLiveData<String>()
    val studentIdDataRequest: LiveData<String> get() = _studentIdDataRequest

    fun studentIdDataRequest(studentId: String){
        _studentIdDataRequest.value = studentId
    }

}