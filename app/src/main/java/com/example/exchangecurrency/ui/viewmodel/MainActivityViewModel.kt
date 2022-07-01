package com.example.exchangecurrency.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.exchangecurrency.domain.Currency
import com.example.exchangecurrency.domain.GetCurrencyRep
import com.example.exchangecurrency.domain.Rates
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.await


class MainActivityViewModel(private val repository: GetCurrencyRep) :
    ViewModel() {

    val scope = CoroutineScope(Dispatchers.Main)
    val rateScope = CoroutineScope(Dispatchers.Main)

    private val _currencyLiveData: MutableLiveData<Currency> = MutableLiveData<Currency>()
    val currencyLiveData: LiveData<Currency> = _currencyLiveData

    private val _rateLiveData: MutableLiveData<Rates> = MutableLiveData<Rates>()
    val rateLiveDta: LiveData<Rates> = _rateLiveData


    fun getData(am: Int) {
        scope.launch {
            val dataFromApi = repository.getCurrency(am).await()
            _currencyLiveData.postValue(dataFromApi)
        }
    }

    fun getRate(){
        rateScope.launch {
            val rateFromApi = repository.getRate().await()
            _rateLiveData.postValue(rateFromApi)
        }
    }
}