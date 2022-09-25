package com.ewiida.e_commerceapp.model.register

data class RegisterResponse(
    val access_token: String,
    val cart_count: Int,
    val expires_at: String,
    val notifications: Int,
    val status: String,
    val token_type: String,
    val user: User
)