package com.example.exchangecurrency.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exchangecurrency.domain.Currency
import com.example.exchangecurrency.domain.GetCurrencyRep
import kotlinx.coroutines.launch
import retrofit2.await


class MainActivityViewModel(private val repository: GetCurrencyRep) :
    ViewModel() {


    private val _currencyLiveData: MutableLiveData<Currency> = MutableLiveData<Currency>()
    val currencyLiveData: LiveData<Currency> = _currencyLiveData

    val userLiveData: MutableLiveData<Int> by lazy { MutableLiveData<Int>() }


    fun getData(am: Int) = viewModelScope.launch {

        val dataFromApi = repository.getCurrency(am).await()
        _currencyLiveData.postValue(dataFromApi)

    }

}