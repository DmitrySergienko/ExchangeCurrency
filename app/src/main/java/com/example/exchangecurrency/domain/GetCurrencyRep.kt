package com.example.exchangecurrency.domain



import retrofit2.Call


interface GetCurrencyRep {

    suspend fun getCurrency() : Call<Currency>
}