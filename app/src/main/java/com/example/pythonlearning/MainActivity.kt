package com.example.pythonlearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.pythonlearning.data.UserPrefs
import com.example.pythonlearning.locale.Locales
import com.example.pythonlearning.presentation.MainScreen
import com.example.pythonlearning.presentation.OnboardingScreen
import com.example.pythonlearning.presentation.pythonTest.loadLocale
import com.example.pythonlearning.presentation.pythonTest.setLocaleLang
import com.example.pythonlearning.ui.theme.PythonLearningTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            var darkTheme by remember { mutableStateOf(UserPrefs.isDarkTheme(this)) }
            var showOnboarding by remember { mutableStateOf(!UserPrefs.isProfileSet(this)) }
            val lyricist = rememberStrings()

            when (loadLocale(this)) {
                "tk" -> lyricist.languageTag = Locales.TM
                "en" -> lyricist.languageTag = Locales.EN
                "ru" -> lyricist.languageTag = Locales.RU
                else -> lyricist.languageTag = Locales.EN
            }

            PythonLearningTheme(darkTheme = darkTheme) {
                ProvideStrings(lyricist) {
                    if (showOnboarding) {
                        OnboardingScreen(
                            onComplete = { lang ->
                                setLocaleLang(lang, this)
                                when (lang) {
                                    "tk" -> lyricist.languageTag = Locales.TM
                                    "en" -> lyricist.languageTag = Locales.EN
                                    "ru" -> lyricist.languageTag = Locales.RU
                                }
                                showOnboarding = false
                            }
                        )
                    } else {
                        MainScreen(
                            lyricist = lyricist,
                            darkTheme = darkTheme,
                            onDarkThemeToggle = { newValue ->
                                darkTheme = newValue
                                UserPrefs.setDarkTheme(this, newValue)
                            }
                        )
                    }
                }
            }
        }
    }
}
