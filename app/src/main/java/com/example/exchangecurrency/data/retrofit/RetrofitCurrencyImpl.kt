package com.example.exchangecurrency.data.retrofit




import com.example.exchangecurrency.BuildConfig
import com.example.exchangecurrency.domain.Currency
import com.example.exchangecurrency.domain.GetCurrencyRep
import retrofit2.Call



class RetrofitCurrencyImpl(
    private val api: ApiService
) : GetCurrencyRep {


    override suspend fun getCurrency(amount: Int): Call<Currency> {
        return api.getCurrency("RUB", "AED", "$amount", BuildConfig.MY_API_KEY)
    }

}
