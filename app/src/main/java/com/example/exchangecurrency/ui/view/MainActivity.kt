package com.example.exchangecurrency.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.exchangecurrency.databinding.ActivityMainBinding
import com.example.exchangecurrency.ui.viewmodel.MainActivityViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {


    //create viewModel
    private val viewModel: MainActivityViewModel by viewModel()


    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonExCurrency.setOnClickListener {
            val userData = binding.editText.text.toString().toInt()
            viewModel.getData(userData)//we are requesting data from liveDat

        }

        viewModel.currencyLiveData.observe(this) {
            val amount = it.result
            binding.textViewExBase.text = amount.toString()
        }



    }
}