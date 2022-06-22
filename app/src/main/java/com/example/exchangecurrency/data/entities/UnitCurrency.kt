package com.example.exchangecurrency.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


//@Entity create table
@Entity(tableName = "unit_ex")
data class UnitEx(

    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "amount") val currencyAmount: Double

)
