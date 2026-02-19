package com.example.pythonlearning.ui.theme

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf
import com.example.pythonlearning.locale.Locales

val LocalAppLanguage = compositionLocalOf {
    mutableStateOf(Locales.RU)
}