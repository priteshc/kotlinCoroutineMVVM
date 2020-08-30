package com.example.kotlincoroutinemvvm.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlincoroutinemvvm.Resource
import com.example.kotlincoroutinemvvm.api.ApiHelper
import kotlinx.coroutines.launch

class SingleNetworkCallViewModel(private val apiHelper: ApiHelper) : ViewModel() {

    private val users = MutableLiveData<Resource<ApiUser>>()

   /* init {
        fetchUsers("test","test")
    }*/

     fun fetchUsers(username : String,password : String) {
        viewModelScope.launch {
            users.postValue(Resource.loading(null))
            try {
                val usersFromApi = apiHelper.getUser(username,password)
                println(usersFromApi)
                users.postValue(Resource.success(usersFromApi))
            } catch (e: Exception) {
                users.postValue(Resource.error(e.toString(), null))
            }
        }
    }

    fun getUsers(): LiveData<Resource<ApiUser>> {
        return users
    }



}