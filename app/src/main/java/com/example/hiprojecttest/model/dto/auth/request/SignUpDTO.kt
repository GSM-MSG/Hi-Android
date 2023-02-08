package com.example.hiprojecttest.model.dto.auth.request

data class SignUpDTO(
    val memberEmail: String,
    val password: String,
    val name: String,
    val number: String,
    val role: String
)