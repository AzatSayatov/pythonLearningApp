package com.example.pythonlearning.presentation.lesson

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.pythonlearning.LocalStrings
import com.example.pythonlearning.PythonRunner
import com.example.pythonlearning.R
import com.example.pythonlearning.rememberStrings

@Composable
fun LessonDetailScreen(x0: Int) {
    val context = LocalContext.current
    val lessons = remember { optLesson(context) }
    val lesson = lessons.get(x0)
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item { Text(text = lesson.title, style = MaterialTheme.typography.headlineSmall,
            color = Color.Black) }
        item { Spacer(modifier = Modifier.height(12.dp)) }
        item { LessonTextCard(lesson.text) }
        items(lesson.body) { item ->
            item.subtitle?.let {
                Spacer(Modifier.height(10.dp))
                Text(text = it, style = MaterialTheme.typography.titleLarge,
                    color = Color.Black)
                Spacer(Modifier.height(10.dp))
            }
            item.subdescription?.let {
                Text(text = it,
                    color = Color.Black)
            }
            item.code?.let {
                if (it.isNotEmpty()) {
                    CodeCard(it, context)
                }
            }
        }
    }
}

@Composable
fun LessonTextCard(text: String) {

    Text(
        modifier = Modifier.padding(vertical = 8.dp),
        text = text,
        color = Color.Black
    )
}

@Composable
fun CodeCard(code: String, context: Context) {
    var inut by remember { mutableStateOf(code) }
    var outPut by remember { mutableStateOf("") }
    var isRunning by remember { mutableStateOf(false) }
    val lyricist = LocalStrings.current
    Column(
        modifier = Modifier.fillMaxWidth()

    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Black)
        ) {
            BasicTextField(
                modifier = Modifier.padding(vertical = 10.dp, horizontal = 10.dp),
                value = inut,
                onValueChange = {
                    inut = it
                },
                textStyle = TextStyle(
                 color = Color.White
                )
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(color = Color.White)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Black)
        ) {
            Text(modifier = Modifier.padding(vertical = 10.dp, horizontal = 10.dp),
                text = "${lyricist.result} : ${outPut}", color = Color.Green)
        }
        Button(
            onClick = {
                isRunning = true
                outPut = PythonRunner.runPythonCode(context, inut, "")
                isRunning = false
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = !isRunning
        ) {
            Text(if (isRunning) "${lyricist.running}..." else "▶ ${lyricist.run}",
                color = Color.White)
        }

    }

}