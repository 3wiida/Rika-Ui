package com.ewiida.e_commerceapp.model.register

data class User(
    val active: Int,
    val address_id: Any,
    val created_at: String,
    val deleted_at: Any,
    val device_type: String,
    val email: Any,
    val email_verified_at: String,
    val id: Int,
    val image: Any,
    val locale: String,
    val name: String,
    val phone: String,
    val phone_code: String,
    val provider: Any,
    val provider_id: Any,
    val type: String,
    val updated_at: String,
    val wallet: Any
)