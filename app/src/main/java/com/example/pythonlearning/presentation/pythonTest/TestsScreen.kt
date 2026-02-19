package com.example.pythonlearning.presentation.pythonTest

import android.app.Activity
import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import cafe.adriel.lyricist.Lyricist
import com.example.pythonlearning.LocalStrings
import com.example.pythonlearning.data.TestItem
import com.example.pythonlearning.locale.Locales
import com.example.pythonlearning.locale.Strings

@Composable
fun TestsScreen(navController: NavController,
                lyricist: Lyricist<Strings>) {
    val strings = LocalStrings.current
    val tests = listOf(
        TestItem(1, "Test: Variables", 10, false),
        TestItem(2, "Test: Conditions", 10, true),
        TestItem(3, "Final Test", 20, false)
    )
    val context = LocalContext.current
    val langCode = when(loadLocale(context)){
        "tk" -> {"Türkmen"}
        "en" -> {"English"}
        "ru" -> {"Русский"}
        else -> {"English"}
    }
    var change by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(strings.settings,
            fontSize = 20.sp,
            fontWeight = FontWeight.W500,
            color = Color.Black)
        Spacer(Modifier.height(20.dp))
        LazyColumn(
            modifier = Modifier.background(
                color = androidx.compose.ui.graphics.Color.White,
                shape = RoundedCornerShape(8.dp)
            )
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            item{
                Row(modifier = Modifier.fillMaxWidth()
                    .clickable{
                        change = true
                    },
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically){
                    Text(strings.language,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.W400,
                        color = Color.Black)
                    Text(text = langCode,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black)
                }
            }
            item {
                Box(modifier = Modifier.fillMaxWidth()
                    .height(1.dp)
                    .background(color = MaterialTheme.colorScheme.secondary))
            }
            item{
                Box(Modifier.fillMaxWidth()
                    .clickable{
                        navController.navigate("test_detail")
                    }){
                    Text(strings.test,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.W400,
                        color = Color.Black)
                }
            }
            loadTestPercent(context)?.let {
                if (it != 0) {
                    item {
                        Box(Modifier.fillMaxWidth()) {
                            Text(
                                strings.lastTest + it + "%",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color.Black
                            )
                        }
                    }
                }
            }
        }
    }
    if (change){
        AlertDialog(
            containerColor = MaterialTheme.colorScheme.tertiary,
            onDismissRequest = {change = false},
            confirmButton = {},
            title = {
                Text(text = strings.changeLanguage,
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.surface)
            },
            text = {
                Column(modifier = Modifier.fillMaxWidth()
                    .background(
                        color  = MaterialTheme.colorScheme.secondary,
                        RoundedCornerShape(8.dp)
                    )
                    .padding(8.dp),
                    verticalArrangement = Arrangement.spacedBy(5.dp)) {
                    Box(Modifier.fillMaxWidth()
                        .clickable{
                            lyricist.languageTag = Locales.TM
                            setLocaleLang("tk",context)
                            change = false
                        }){
                        Text(text = "Türkmen",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.W400,
                            color = MaterialTheme.colorScheme.surface)
                    }

                    Box(Modifier.fillMaxWidth()
                        .background(color = MaterialTheme.colorScheme.tertiary)
                        .height(1.dp))
                    Box(Modifier.fillMaxWidth()
                        .clickable{
                            lyricist.languageTag = Locales.EN
                            setLocaleLang("en",context)
                            change = false
                        }) {
                        Text(
                            text = "English",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.W400,
                            color = MaterialTheme.colorScheme.surface
                        )
                    }

                    Box(Modifier.fillMaxWidth()
                        .background(color = MaterialTheme.colorScheme.tertiary)
                        .height(1.dp))
                    Box(Modifier.fillMaxWidth()
                        .clickable{
                            lyricist.languageTag = Locales.RU
                            setLocaleLang("ru",context)
                            change = false
                        }) {
                        Text(
                            text = "Русский",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.W400,
                            color = MaterialTheme.colorScheme.surface
                        )
                    }
                }
            }
        )
    }

}
fun setLocaleLang(lang: String, context: Context) {
    val editor = context.getSharedPreferences("Settings", Context.MODE_PRIVATE).edit()
    editor.putString("My_Lang", lang)
    editor.apply()
}

fun loadLocale(context: Context): String? {
    val sharedPreferences = context.getSharedPreferences("Settings", Activity.MODE_PRIVATE)
    val language = sharedPreferences.getString("My_Lang", "")
    return language
}
fun setTestPercent(percent: Int, context: Context) {
    val editor = context.getSharedPreferences("Settings", Context.MODE_PRIVATE).edit()
    editor.putInt("My_Test", percent)
    editor.apply()
}

fun loadTestPercent(context: Context): Int? {
    val sharedPreferences = context.getSharedPreferences("Settings", Activity.MODE_PRIVATE)
    val language = sharedPreferences.getInt("My_Test", 0)
    return language
}

@Composable
fun TestCard(test: TestItem, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(test.title, style = MaterialTheme.typography.titleLarge)
            Text("${test.questionCount} questions", style = MaterialTheme.typography.bodySmall)
            Text(if (test.passed) "Passed ✅" else "Not passed ❌")
        }
    }
}
