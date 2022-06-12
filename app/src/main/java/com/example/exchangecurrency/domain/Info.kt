package com.example.exchangecurrency.domain


import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

const val RATE = "rate"
const val TIMESTEMP = "timestamp"

@Keep
@Parcelize
data class Info(
    @SerializedName(RATE)
    val rate: Double,
    @SerializedName(TIMESTEMP)
    val timestamp: Int
): Parcelable