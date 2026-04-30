package com.example.pythonlearning.presentation.pythonTest

import android.app.Activity
import android.content.Context

fun setLocaleLang(lang: String, context: Context) {
    val editor = context.getSharedPreferences("Settings", Context.MODE_PRIVATE).edit()
    editor.putString("My_Lang", lang)
    editor.apply()
}

fun loadLocale(context: Context): String? {
    val sharedPreferences = context.getSharedPreferences("Settings", Activity.MODE_PRIVATE)
    return sharedPreferences.getString("My_Lang", "en")
}

fun setTestPercent(percent: Int, context: Context) {
    val editor = context.getSharedPreferences("Settings", Context.MODE_PRIVATE).edit()
    editor.putInt("My_Test", percent)
    editor.apply()
}

fun loadTestPercent(context: Context): Int? {
    val sharedPreferences = context.getSharedPreferences("Settings", Activity.MODE_PRIVATE)
    return sharedPreferences.getInt("My_Test", 0)
}
