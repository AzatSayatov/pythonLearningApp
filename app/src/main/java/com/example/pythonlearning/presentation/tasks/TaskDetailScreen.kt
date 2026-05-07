package com.example.pythonlearning.presentation.tasks

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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
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
import com.example.pythonlearning.data.tasks.AppLanguage
import com.example.pythonlearning.data.tasks.Difficulty
import com.example.pythonlearning.data.tasks.PythonTasks
import com.example.pythonlearning.data.tasks.localizedDescription
import com.example.pythonlearning.data.tasks.localizedHint
import com.example.pythonlearning.data.tasks.localizedTitle
import com.example.pythonlearning.presentation.pythonTest.loadLocale
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
fun TaskDetailScreen(taskId: Int) {
    val task = PythonTasks.tasks.find { it.id == taskId } ?: return

    val context = LocalContext.current
    var code by remember { mutableStateOf(task.starterCode) }
    var inputData by remember { mutableStateOf("") }
    var output by remember { mutableStateOf("") }
    var isRunning by remember { mutableStateOf(false) }
    val lyricist = LocalStrings.current
    val langCode = loadLocale(context)
    val lang = when (langCode) {
        "ru" -> AppLanguage.RU
        "tk" -> AppLanguage.TM
        else -> AppLanguage.EN
    }

    val suggestions = remember(code) { getSuggestions(code) }

    val difficultyColor = when (task.difficulty) {
        Difficulty.BEGINNER -> Color(0xFF4CAF50)
        Difficulty.INTERMEDIATE -> Color(0xFFFFC107)
        Difficulty.ADVANCED -> Color(0xFFF44336)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.secondary)
            .padding(16.dp)
    ) {
        // Title + badge
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = task.localizedTitle(lang),
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.weight(1f)
            )
            Surface(
                shape = RoundedCornerShape(20.dp),
                color = difficultyColor.copy(alpha = 0.15f)
            ) {
                Text(
                    text = when (task.difficulty) {
                        Difficulty.BEGINNER -> "Beginner"
                        Difficulty.INTERMEDIATE -> "Intermediate"
                        Difficulty.ADVANCED -> "Advanced"
                    },
                    color = difficultyColor,
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Description (условие задачи)
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            )
        ) {
            Column(modifier = Modifier.padding(14.dp)) {
                Text(
                    text = "📋 ${lyricist.taskDescription}",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = task.localizedDescription(lang),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
                if (task.hint.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "💡 ${lyricist.hint}: ${task.localizedHint(lang)}", // "Подсказка"
                        style = MaterialTheme.typography.bodySmall,
                        color = difficultyColor.copy(alpha = 0.8f)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Code editor
        OutlinedTextField(
            value = code,
            onValueChange = { code = it },
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            label = { Text(lyricist.code) },
            textStyle = TextStyle(
                color = MaterialTheme.colorScheme.onSurface,
                fontFamily = FontFamily.Monospace
            )
        )

        // Autocomplete suggestions
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

        Spacer(modifier = Modifier.height(8.dp))

        // Output terminal
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.Black
            )
        ) {
            Text(
                text = if (output.isEmpty()) "$ run your code..." else output,
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxSize(),
                color = Color.White,
                fontFamily = FontFamily.Monospace
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Input row
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                "> ",
                fontFamily = FontFamily.Monospace,
                color = MaterialTheme.colorScheme.onBackground
            )
            OutlinedTextField(
                value = inputData,
                onValueChange = { inputData = it },
                modifier = Modifier.weight(1f),
                placeholder = {
                    Text(lyricist.input, color = MaterialTheme.colorScheme.onSurfaceVariant)
                },
                singleLine = false,
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Run button
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