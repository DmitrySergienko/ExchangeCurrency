package com.example.exchangecurrency.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exchangecurrency.domain.Currency
import com.example.exchangecurrency.domain.GetCurrencyRep
import kotlinx.coroutines.launch

import retrofit2.Call
import retrofit2.await


class MainActivityViewModel(private val repository: GetCurrencyRep) :
    ViewModel() {


    private val _currencyLiveData: MutableLiveData<Currency> = MutableLiveData<Currency>()
    val currencyLiveData: LiveData<Currency>  = _currencyLiveData


    //get data from api
    fun getData() = viewModelScope.launch{
        val dataFromApi = repository.getCurrency().await()
        _currencyLiveData.postValue(dataFromApi)//put our data to LiveData

    }

}