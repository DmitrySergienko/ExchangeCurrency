package com.example.exchangecurrency

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.exchangecurrency.data.CurrencyDatabase
import com.example.exchangecurrency.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(appModule)
        }
    }

    fun getRoom() =
        Room.databaseBuilder(
            applicationContext, CurrencyDatabase::class.java, "currency_database"
        )
            .build()

}

val Context.app: App
    get() = applicationContext as App
