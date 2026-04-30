package com.example.pythonlearning.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pythonlearning.LocalStrings
import com.example.pythonlearning.PythonRunner
import com.example.pythonlearning.ui.theme.BluePrimary

private val pythonKeywords = listOf(
    "print(", "input(", "len(", "range(", "int(", "float(", "str(", "bool(",
    "list(", "dict(", "tuple(", "set(", "type(", "isinstance(", "hasattr(",
    "if ", "elif ", "else:", "for ", "while ", "break", "continue", "pass",
    "def ", "class ", "return ", "import ", "from ", "as ", "with ", "lambda ",
    "try:", "except ", "finally:", "raise ", "yield ", "global ", "nonlocal ",
    "True", "False", "None", "and ", "or ", "not ", "in ", "is ",
    "append(", "extend(", "pop(", "remove(", "insert(", "sort(", "reverse(",
    "split(", "join(", "strip(", "replace(", "upper(", "lower(", "format(",
    "open(", "read(", "write(", "close(", "enumerate(", "zip(", "map(", "filter(",
    "sorted(", "max(", "min(", "sum(", "abs(", "round("
)

private fun getSuggestions(text: String): List<String> {
    if (text.isEmpty()) return emptyList()
    val lastWord = text.split(" ", "\n", "(", ".", ",").last()
    if (lastWord.length < 2) return emptyList()
    return pythonKeywords
        .filter { it.startsWith(lastWord, ignoreCase = true) && it != lastWord }
        .take(6)
}

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

    val suggestions = remember(code) { getSuggestions(code) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.secondary)
            .padding(16.dp)
    ) {
        Text(
            text = taskTitle ?: lyricist.pythonPlayground,
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.surface
        )
        Spacer(Modifier.height(12.dp))

        // Code editor
        OutlinedTextField(
            value = code,
            onValueChange = { code = it },
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            label = { Text(lyricist.code) },
            textStyle = TextStyle(
                color = MaterialTheme.colorScheme.surface,
                fontFamily = FontFamily.Monospace,
                fontSize = 14.sp
            )
        )

        // Autocomplete suggestions row
        if (suggestions.isNotEmpty()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                suggestions.forEach { suggestion ->
                    Box(
                        modifier = Modifier
                            .background(BluePrimary.copy(0.15f), RoundedCornerShape(6.dp))
                            .clickable {
                                // Replace last partial word with suggestion
                                val lines = code.split("\n").toMutableList()
                                if (lines.isNotEmpty()) {
                                    val lastLine = lines.last()
                                    val lastWord = lastLine.split(" ", "(", ".", ",").last()
                                    lines[lines.lastIndex] = lastLine.dropLast(lastWord.length) + suggestion
                                    code = lines.joinToString("\n")
                                }
                            }
                            .padding(horizontal = 10.dp, vertical = 6.dp)
                    ) {
                        Text(
                            text = suggestion,
                            color = BluePrimary,
                            fontSize = 12.sp,
                            fontFamily = FontFamily.Monospace
                        )
                    }
                }
            }
        }

        Spacer(Modifier.height(8.dp))

        // Output terminal
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1E2E))
        ) {
            Text(
                text = when {
                    isRunning -> "⏳ ${lyricist.running}..."
                    output.isEmpty() -> "$ run your code..."
                    else -> output
                },
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxSize(),
                color = if (output.isEmpty() && !isRunning) Color(0xFF6A9FB5) else Color(0xFF50FA7B),
                fontFamily = FontFamily.Monospace,
                fontSize = 13.sp
            )
        }

        Spacer(Modifier.height(8.dp))

        // Input row
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                "> ",
                fontFamily = FontFamily.Monospace,
                color = MaterialTheme.colorScheme.surface.copy(0.6f)
            )
            OutlinedTextField(
                value = inputData,
                onValueChange = { inputData = it },
                modifier = Modifier.weight(1f),
                placeholder = { Text(lyricist.input, color = MaterialTheme.colorScheme.surface.copy(0.4f)) },
                singleLine = false,
                textStyle = TextStyle(color = MaterialTheme.colorScheme.surface)
            )
        }

        Spacer(Modifier.height(8.dp))

        Button(
            onClick = {
                isRunning = true
                output = PythonRunner.runPythonCode(context, code, inputData)
                isRunning = false
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(containerColor = BluePrimary),
            enabled = !isRunning,
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(
                if (isRunning) "⏳ ${lyricist.running}..." else "▶ ${lyricist.run}",
                color = Color.White
            )
        }
    }
}
