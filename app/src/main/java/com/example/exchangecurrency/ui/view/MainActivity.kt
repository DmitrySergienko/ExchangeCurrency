package com.example.exchangecurrency.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.exchangecurrency.databinding.ActivityMainBinding
import com.example.exchangecurrency.ui.viewmodel.MainActivityViewModel
import com.example.exchangecurrency.ui.viewmodel.MainActivityViewModelContract

class MainActivity : AppCompatActivity() {

    //create viewModel
    private val viewModel: MainActivityViewModelContract.ViewModel by lazy {
        ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.button.setOnClickListener {
            //we are requesting data from viewModel
            viewModel.getData()

        }

        viewModel.data.observe(this) {
            binding.textView.text = it
        }
    }
}