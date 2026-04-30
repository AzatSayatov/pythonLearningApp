package com.example.pythonlearning.data

import android.content.Context

object UserPrefs {
    private const val PREFS = "user_prefs"

    fun saveProfile(context: Context, name: String, surname: String, age: String, reason: String) {
        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE).edit().apply {
            putString("name", name)
            putString("surname", surname)
            putString("age", age)
            putString("reason", reason)
            putBoolean("profile_set", true)
            apply()
        }
    }

    fun isProfileSet(context: Context): Boolean =
        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE).getBoolean("profile_set", false)

    fun getName(context: Context): String =
        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE).getString("name", "") ?: ""

    fun getSurname(context: Context): String =
        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE).getString("surname", "") ?: ""

    fun getAge(context: Context): String =
        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE).getString("age", "") ?: ""

    fun getReason(context: Context): String =
        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE).getString("reason", "") ?: ""

    fun isDarkTheme(context: Context): Boolean =
        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE).getBoolean("dark_theme", false)

    fun setDarkTheme(context: Context, dark: Boolean) {
        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE).edit()
            .putBoolean("dark_theme", dark).apply()
    }

    fun getLessonTestScore(context: Context, lessonId: Int): Int =
        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE).getInt("lesson_test_$lessonId", -1)

    fun setLessonTestScore(context: Context, lessonId: Int, score: Int) {
        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE).edit()
            .putInt("lesson_test_$lessonId", score).apply()
    }

    fun isLessonUnlocked(context: Context, lessonId: Int): Boolean {
        if (lessonId == 0) return true
        val prevScore = getLessonTestScore(context, lessonId - 1)
        return prevScore >= 70
    }
}
