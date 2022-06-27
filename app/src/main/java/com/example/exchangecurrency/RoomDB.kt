package com.example.exchangecurrency

import android.content.Context
import androidx.room.Room
import com.example.exchangecurrency.data.CurrencyDatabase

class RoomDB() {
    fun getRoom(context: Context) =
        Room.databaseBuilder(
            context, CurrencyDatabase::class.java, "currency_database"
        )
            .build()
}