package com.example.exchangecurrency.domain

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class Rates(

	@field:SerializedName("date")
	val date: String? = null,
	@field:SerializedName("success")
	val success: Boolean? = null,
	@field:SerializedName("rates")
	val rates: Rates? = null,
	@field:SerializedName("base")
	val base: String? = null,
	@field:SerializedName("timestamp")
	val timestamp: Int? = null,
	@field:SerializedName("EUR")
	val eUR: Double? = null,
	@field:SerializedName("AED")
	val aED: Double? = null

) : Parcelable
