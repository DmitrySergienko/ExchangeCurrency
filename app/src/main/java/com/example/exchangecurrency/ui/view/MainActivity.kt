package com.example.exchangecurrency.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.example.exchangecurrency.app
import com.example.exchangecurrency.data.entities.UnitEx
import com.example.exchangecurrency.databinding.ActivityMainBinding
import com.example.exchangecurrency.ui.viewmodel.MainActivityViewModel
import kotlinx.coroutines.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {

    //create viewModel
    private val viewModel: MainActivityViewModel by viewModel()

    val scope = CoroutineScope(Dispatchers.IO)
    var job: Job? = null

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonExCurrency.setOnClickListener {
            val userData = binding.editText.text.toString().toInt()
            viewModel.getData(userData)//we are requesting data from liveDat

            binding.image.load("https://firebasestorage.googleapis.com/v0/b/fairytale-cc1c4.appspot.com/o/Exchange_simple.png?alt=media&token=e5433cbf-4208-4c7e-9db9-35570f31e27c")
        }

        viewModel.currencyLiveData.observe(this) {
            val amount = it.result
            binding.textViewExBase.text = amount.toString()

            job?.cancel()
            job = scope.launch {
                val dao = app.getRoom().currencyDao()
                dao.insertOneUnit(UnitEx(1, it.result))
                println("VVV ${dao.getAll()}")
            }

        }
    }
}