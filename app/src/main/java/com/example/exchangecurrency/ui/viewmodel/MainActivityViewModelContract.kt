package com.example.exchangecurrency.ui.viewmodel

import androidx.lifecycle.LiveData

interface MainActivityViewModelContract {
    abstract class ViewModel: androidx.lifecycle.ViewModel(){
        abstract val data: LiveData<String>

        abstract fun getData()
    }
}