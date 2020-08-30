package com.example.kotlincoroutinemvvm.api

import com.example.kotlincoroutinemvvm.model.ApiUser
import retrofit2.Call

interface ApiHelper {

    suspend fun getUser (uname : String,pass : String) : ApiUser

}