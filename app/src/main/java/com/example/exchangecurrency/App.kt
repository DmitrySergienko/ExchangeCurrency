package com.example.exchangecurrency

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import androidx.room.Room
import com.example.exchangecurrency.data.CurrencyDatabase
import com.example.exchangecurrency.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

const val CURRENCY_DATABASE = "currency_database"

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        MultiDex.install(this)

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(appModule)
        }
    }

    fun getRoom() =
        Room.databaseBuilder(
            applicationContext, CurrencyDatabase::class.java, CURRENCY_DATABASE
        )
            .build()

}

val Context.app: App
    get() = applicationContext as App
