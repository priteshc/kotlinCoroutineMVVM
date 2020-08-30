package com.example.kotlincoroutinemvvm.api

import com.example.kotlincoroutinemvvm.model.ApiUser
import retrofit2.Call

class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {

    override suspend fun getUser(uname: String, pass: String) = apiService.getUser(uname, pass)

}