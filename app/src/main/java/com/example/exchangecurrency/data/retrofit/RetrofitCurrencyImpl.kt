package com.example.exchangecurrency.data.retrofit


import com.example.exchangecurrency.domain.Currency
import com.example.exchangecurrency.domain.GetCurrencyRep
import retrofit2.Call


private const val API_KEY = "IMQ9MJKNI9l8X7hL00rkpwzofh8AFjUY"

class RetrofitCurrencyImpl(
    private val api: ApiService
) : GetCurrencyRep {


    override suspend fun getCurrency(): Call<Currency> {
        return api.getCurrency("RUB", "AED", "1", API_KEY)
    }
}
