package com.example.exchangecurrency.data.retrofit


import com.example.exchangecurrency.domain.Currency
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {


    @GET("exchangerates_data/convert")
    fun getCurrency(
        @Query("to") to: String,
        @Query("from") from: String,
        @Query("amount") amount: String,
        @Header("apiKey") apiKey: String,
    ) : Currency
}