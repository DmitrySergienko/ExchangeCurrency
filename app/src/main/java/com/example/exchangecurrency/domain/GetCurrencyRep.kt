package com.example.exchangecurrency.domain


import retrofit2.Call

interface GetCurrencyRep {

    suspend fun getCurrency(amount: Int) : Call<Currency>
    suspend fun getRate(): Call<Rates>

}