package com.ummaaack.halueumpyo.data

import android.content.Context
import android.content.SharedPreferences


object HaluEumpyoRepository {
    private lateinit var preferences: SharedPreferences

    const val SERVICE_RATING = "SERVICE_RATING"

    fun init(context: Context) {
        preferences = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var serviceRating: Boolean
        get() = preferences.getBoolean(SERVICE_RATING, false)
        set(value) = preferences.edit { it.putBoolean(SERVICE_RATING, value) }
}