package com.example.exchangecurrency.data.retrofit


import com.example.exchangecurrency.domain.Currency
import com.example.exchangecurrency.domain.Rates
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

private const val TO = "to"
private const val FROM = "from"
private const val AMOUNT = "amount"
private const val APIKEY = "apiKey"
private const val SYMBOLS = "symbols"
private const val BASE = "base"

interface ApiService {


    @GET("exchangerates_data/convert")
    fun getCurrency(
        @Query(TO) to: String,
        @Query(FROM) from: String,
        @Query(AMOUNT) amount: String,
        @Header(APIKEY) apiKey: String,
    ) : Call<Currency>

    @GET("exchangerates_data/latest")
    fun getRate(
        @Query(SYMBOLS) symbols: String,
        @Query(BASE) base: String,
        @Header(APIKEY) apiKey: String,
    ): Call<Rates>

}