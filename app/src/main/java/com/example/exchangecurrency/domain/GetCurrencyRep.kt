package com.example.exchangecurrency.domain


interface GetCurrencyRep {

    suspend fun getCurrency(amount: Int) : Currency
}