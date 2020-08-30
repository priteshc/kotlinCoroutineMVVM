package com.example.kotlincoroutinemvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.kotlincoroutinemvvm.api.ApiHelperImpl
import com.example.kotlincoroutinemvvm.api.RetrofitBuilder
import com.example.kotlincoroutinemvvm.model.SingleNetworkCallViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: SingleNetworkCallViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewModel()
        setupObserver()

        press.setOnClickListener {

         viewModel.fetchUsers("test","test")

        }

    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(this,
            ViewModelFactory(ApiHelperImpl(RetrofitBuilder.apiService)))
            .get(SingleNetworkCallViewModel::class.java)
    }

    private fun setupObserver() {
        viewModel.getUsers().observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    progressBar.visibility = View.GONE
                   /* it.data?.let { users -> renderList(users) }
                    recyclerView.visibility = View.VISIBLE*/
                    Toast.makeText(this, it.data?.message, Toast.LENGTH_LONG).show()

                }
                Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                //    recyclerView.visibility = View.GONE
                }
                Status.ERROR -> {
                    //Handle Error
                    progressBar.visibility = View.GONE
                    Toast.makeText(this, "error", Toast.LENGTH_LONG).show()
                }
            }
        })
    }

}