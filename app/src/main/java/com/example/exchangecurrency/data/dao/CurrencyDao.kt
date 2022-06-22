package com.example.exchangecurrency.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


import com.example.exchangecurrency.data.entities.UnitEx

//generate request to BD
@Dao
interface CurrencyDao {

    //insert objects into bd
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCurrency(currency: List<UnitEx>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOneUnit(currency: UnitEx)

    // get all from bd
    @Query("select * from unit_ex")
    fun getAll(): List<UnitEx>
}