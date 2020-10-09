package com.example.mvvm_databinding

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvm_databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel=ViewModelProviders.of(this).get(MainViewModel::class.java)

        binding.viewModel=viewModel

        viewModel.message.observe(this, Observer { res ->
            if (res != null) {
                val message = res.format(this)
                Toast.makeText(this, message, Toast.LENGTH_LONG).show()
            }
        })
    }
}