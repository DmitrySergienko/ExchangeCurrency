package com.example.exchangecurrency.domain


import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

private const val AMOUNT = "amount"
private const val FROM = "from"
private const val TO = "to"

@Parcelize
@Keep
data class Query(
    @SerializedName(AMOUNT)
    val amount: Int,
    @SerializedName(FROM)
    val from: String,
    @SerializedName(TO)
    val to: String
):Parcelable