package com.example.pythonlearning.presentation.lesson

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pythonlearning.LocalStrings
import com.example.pythonlearning.PythonRunner
import com.example.pythonlearning.ui.theme.BluePrimary

@Composable
fun LessonDetailScreen(x0: Int, navController: NavController? = null) {
    val context = LocalContext.current
    val lessons = remember { optLesson(context) }
    val lesson = lessons.getOrNull(x0) ?: return
    val lyricist = LocalStrings.current

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.secondary)
            .padding(16.dp)
    ) {
        item {
            Text(
                text = lesson.title,
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.surface,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = lesson.description,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.surface.copy(0.6f)
            )
            Spacer(Modifier.height(16.dp))
        }

        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(MaterialTheme.colorScheme.tertiary)
                    .padding(14.dp)
            ) {
                Text(
                    text = lesson.text,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.surface,
                    lineHeight = 22.sp
                )
            }
            Spacer(Modifier.height(12.dp))
        }

        items(lesson.body) { item ->
            if (!item.subtitle.isNullOrEmpty()) {
                Spacer(Modifier.height(10.dp))
                Text(
                    text = item.subtitle,
                    style = MaterialTheme.typography.titleMedium,
                    color = BluePrimary,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(Modifier.height(6.dp))
            }
            item.subdescription?.let { desc ->
                Text(
                    text = desc,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.surface,
                    lineHeight = 22.sp
                )
                Spacer(Modifier.height(8.dp))
            }
            item.code?.let { code ->
                if (code.isNotEmpty()) {
                    CodeCard(code, context)
                    Spacer(Modifier.height(12.dp))
                }
            }
        }

        item {
            Spacer(Modifier.height(16.dp))
            Button(
                onClick = { navController?.navigate("lesson_test/$x0") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                colors = ButtonDefaults.buttonColors(containerColor = BluePrimary),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "▶ ${lyricist.takeTest}",
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp
                )
            }
            Spacer(Modifier.height(24.dp))
        }
    }
}

@Composable
fun LessonTextCard(text: String) {
    Text(
        modifier = Modifier.padding(vertical = 8.dp),
        text = text,
        color = MaterialTheme.colorScheme.surface,
        lineHeight = 22.sp
    )
}

@Composable
fun CodeCard(code: String, context: Context) {
    var inputCode by remember { mutableStateOf(code) }
    var outPut by remember { mutableStateOf("") }
    var isRunning by remember { mutableStateOf(false) }
    val lyricist = LocalStrings.current

    Column(modifier = Modifier.fillMaxWidth()) {
        // Title bar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp))
                .background(Color(0xFF1E1E2E))
                .padding(horizontal = 12.dp, vertical = 6.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Python", color = Color(0xFF6A9FB5), fontSize = 11.sp, fontFamily = FontFamily.Monospace)
                Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    Box(modifier = Modifier.size(10.dp).clip(CircleShape).background(Color(0xFFFF5F57)))
                    Box(modifier = Modifier.size(10.dp).clip(CircleShape).background(Color(0xFFFFBD2E)))
                    Box(modifier = Modifier.size(10.dp).clip(CircleShape).background(Color(0xFF28CA41)))
                }
            }
        }
        // Code area
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF282A36))
        ) {
            BasicTextField(
                modifier = Modifier
                    .padding(horizontal = 12.dp, vertical = 10.dp)
                    .fillMaxWidth(),
                value = inputCode,
                onValueChange = { inputCode = it },
                textStyle = TextStyle(
                    color = Color(0xFFE8E8FF),
                    fontFamily = FontFamily.Monospace,
                    fontSize = 13.sp,
                    lineHeight = 20.sp
                )
            )
        }
        // Divider
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(0.5.dp)
                .background(Color(0xFF44475A))
        )
        // Output
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF1A1A2A))
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                text = if (outPut.isEmpty()) "// ${lyricist.result}" else outPut,
                color = if (outPut.isEmpty()) Color(0xFF6A9FB5) else Color(0xFF50FA7B),
                fontFamily = FontFamily.Monospace,
                fontSize = 12.sp
            )
        }
        // Run button
        Button(
            onClick = {
                isRunning = true
                outPut = PythonRunner.runPythonCode(context, inputCode, "")
                isRunning = false
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF44475A)),
            shape = RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp)
        ) {
            Text(
                if (isRunning) "⏳ ${lyricist.running}..." else "▶ ${lyricist.run}",
                color = Color.White,
                fontSize = 13.sp
            )
        }
    }
}
