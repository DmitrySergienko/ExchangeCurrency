package com.example.exchangecurrency.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exchangecurrency.domain.Currency
import com.example.exchangecurrency.domain.GetCurrencyRep
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.await


class MainActivityViewModel(private val repository: GetCurrencyRep) :
    ViewModel() {

    val scope = CoroutineScope(Dispatchers.Main)

    private val _currencyLiveData: MutableLiveData<Currency> = MutableLiveData<Currency>()
    val currencyLiveData: LiveData<Currency> = _currencyLiveData


    fun getData(am: Int) {

        scope.launch {
            val dataFromApi = repository.getCurrency(am).await()
            _currencyLiveData.postValue(dataFromApi)
        }
    }
}