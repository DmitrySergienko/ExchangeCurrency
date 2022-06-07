package com.example.dictionaryapp.data.retrofit.currency


import com.example.exchangecurrency.data.retrofit.currency.ApiService
import com.example.exchangecurrency.domain.Currency
import com.example.exchangecurrency.domain.GetCurrencyRep
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private const val API_KEY = "IMQ9MJKNI9l8X7hL00rkpwzofh8AFjUY"

class RetrofitCurrencyImpl : GetCurrencyRep {

    private val retrofit = Retrofit.Builder()

        .baseUrl("https://api.apilayer.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val api: ApiService = retrofit.create(ApiService::class.java)


    override suspend fun getCurrency(amount: Int): Currency {
        return api.getCurrency("RUB", "AED", "$amount", API_KEY)
    }
}
