package com.ewiida.e_commerceapp.api

import com.ewiida.e_commerceapp.model.login.User
import com.ewiida.e_commerceapp.model.register.RegisterResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface RikaApi {
    @FormUrlEncoded
    @POST("login")
    suspend fun login(
        @Field("phone") phone:String,
        @Field("password") password:String,
        @Field("imei") imei:String,
        @Field("token") token:String,
        @Field("device_type") device_type:String
    ): User

    @FormUrlEncoded
    @POST("register")
    suspend fun register(
        @Field("phone") phone:String,
        @Field("name") name:String,
        @Field("city_id") cityId:Int,
        @Field("password") password:String,
        @Field("confirm_password") confirmPassword:String,
        @Field("imei") imei:String,
        @Field("token") token:String,
        @Field("device_type") device_type:String
    ): RegisterResponse
}