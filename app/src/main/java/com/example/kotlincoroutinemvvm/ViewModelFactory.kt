package com.example.kotlincoroutinemvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlincoroutinemvvm.api.ApiHelper
import com.example.kotlincoroutinemvvm.model.SingleNetworkCallViewModel

class ViewModelFactory(private val apiHelper: ApiHelper) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SingleNetworkCallViewModel::class.java)) {
            return SingleNetworkCallViewModel(apiHelper) as T
        }

        throw IllegalArgumentException("Unknown class name")
    }

}