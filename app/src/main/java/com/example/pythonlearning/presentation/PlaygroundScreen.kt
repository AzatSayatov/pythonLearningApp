package com.example.pythonlearning.presentation

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.pythonlearning.LocalStrings
import com.example.pythonlearning.PythonRunner
import com.example.pythonlearning.rememberStrings

@Composable
fun PlaygroundScreen(
    initialCode: String = "print('Hello World!')",
    taskTitle: String? = null
) {
    val context = LocalContext.current
    var code by remember { mutableStateOf(initialCode) }
    var inputData by remember { mutableStateOf("") }
    var output by remember { mutableStateOf("") }
    var isRunning by remember { mutableStateOf(false) }
    val lyricist = LocalStrings.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = taskTitle ?: lyricist.pythonPlayground, style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.surface)
        Spacer(modifier = Modifier.height(12.dp))

        // Код
        OutlinedTextField(
            value = code,
            onValueChange = { code = it },
            modifier = Modifier.fillMaxWidth().weight(1f),
            label = { Text(lyricist.code) },
            textStyle = TextStyle(
                color = MaterialTheme.colorScheme.surface
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Терминал — вывод
        Card(
            modifier = Modifier.fillMaxWidth().height(160.dp),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Black)
        ) {
            Text(
                text = if (output.isEmpty()) "$ run your code..." else output,
                modifier = Modifier.padding(12.dp).fillMaxSize(),
                color = Color.White,
                fontFamily = androidx.compose.ui.text.font.FontFamily.Monospace
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Строка ввода — как терминал
        Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
            Text("> ", fontFamily = androidx.compose.ui.text.font.FontFamily.Monospace,
                color = MaterialTheme.colorScheme.surface)
            OutlinedTextField(
                value = inputData,
                onValueChange = { inputData = it },
                modifier = Modifier.weight(1f),
                placeholder = { Text(lyricist.input,color = MaterialTheme.colorScheme.surface) },
                singleLine = false,
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                isRunning = true
                output = PythonRunner.runPythonCode(context, code, inputData)
                isRunning = false
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = !isRunning
        ) {
            Text(if (isRunning) "${lyricist.running}..." else "▶ ${lyricist.run}")
        }
    }
}

