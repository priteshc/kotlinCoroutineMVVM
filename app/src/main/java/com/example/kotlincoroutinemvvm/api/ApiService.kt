package com.example.kotlincoroutinemvvm.api

import com.example.kotlincoroutinemvvm.model.ApiUser
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("end point")
    suspend fun getUser(@Field("email") uname:String, @Field("mobile") pass : String): ApiUser

}