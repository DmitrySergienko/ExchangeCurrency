package com.example.exchangecurrency.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.exchangecurrency.domain.Currency
import com.example.exchangecurrency.domain.GetCurrencyRep

class MainActivityViewModel(private val repository: GetCurrencyRep) :
    ViewModel() {


    private val _currencyLiveData: MutableLiveData<Currency> = MutableLiveData<Currency>()
    val currencyLiveData: LiveData<Currency> = _currencyLiveData


    //get data from api
    fun getData() {

        val dataFromApi = repository.getCurrency()
        _currencyLiveData.postValue(dataFromApi)//put our data to LiveData

    }

}