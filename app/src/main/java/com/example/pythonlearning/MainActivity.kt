package com.example.pythonlearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.pythonlearning.locale.Locales
import com.example.pythonlearning.presentation.MainScreen
import com.example.pythonlearning.presentation.SplashScreen
import com.example.pythonlearning.presentation.pythonTest.loadLocale
import com.example.pythonlearning.ui.theme.PythonLearningTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        enableEdgeToEdge()

        setContent {
            PythonLearningTheme(darkTheme = false) {
                val lyricist = rememberStrings()
                when(loadLocale(this)){
                    "tk" -> {lyricist.languageTag = Locales.TM}
                    "en" -> {lyricist.languageTag = Locales.EN}
                    "ru" -> {lyricist.languageTag = Locales.RU}
                    else -> {lyricist.languageTag = Locales.EN}
                }
                var showSplash by remember { mutableStateOf(true) }

                ProvideStrings(lyricist) {
                    // твой контент


//                    if (showSplash) {
//                        SplashScreen(onFinished = { showSplash = false })
//                    }else {
                        MainScreen(lyricist)
//                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PythonLearningTheme {
        Greeting("Android")
    }
}