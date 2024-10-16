package com.steradiantest.car.utils

import android.util.Log
import java.text.NumberFormat
import java.util.Locale

fun String.toRupiah(): String {
    try {
        val numberFormat = NumberFormat.getCurrencyInstance(Locale("in", "ID"))
        return numberFormat.format(this).toString()
    } catch (e: Exception) {
        Log.e("TAG", "toRupiah: $e", )
        return ""
    }
}