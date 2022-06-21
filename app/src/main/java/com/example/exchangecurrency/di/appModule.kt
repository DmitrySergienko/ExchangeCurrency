package com.example.exchangecurrency.di


import com.example.exchangecurrency.data.retrofit.ApiService
import com.example.exchangecurrency.data.retrofit.RetrofitCurrencyImpl
import com.example.exchangecurrency.domain.GetCurrencyRep
import com.example.exchangecurrency.ui.viewmodel.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


val appModule = module {
    single(named("base_url")) { "https://api.apilayer.com/" }

    single<GetCurrencyRep> { RetrofitCurrencyImpl(api = get()) }
    single<ApiService> { get<Retrofit>().create(ApiService::class.java) }

    single {
        Retrofit.Builder()
            .baseUrl(get<String>(named("base_url")))
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(get())
            .build()
    }
    factory<Converter.Factory> { GsonConverterFactory.create() }

    viewModel { MainActivityViewModel(repository = get()) }

    factory {  }

}


