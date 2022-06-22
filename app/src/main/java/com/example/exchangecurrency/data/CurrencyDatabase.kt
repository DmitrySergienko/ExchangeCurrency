package com.example.exchangecurrency.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.exchangecurrency.data.dao.CurrencyDao
import com.example.exchangecurrency.data.entities.UnitEx


@Database(entities = [UnitEx::class], version = 1, exportSchema = true)
abstract class  CurrencyDatabase() : RoomDatabase(){

    //fun() return DAO
    abstract fun currencyDao(): CurrencyDao
}