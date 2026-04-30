package com.example.pythonlearning.presentation.pythonTest

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pythonlearning.LocalStrings
import com.example.pythonlearning.data.LessonQuestions
import com.example.pythonlearning.data.Question
import com.example.pythonlearning.ui.theme.BluePrimary

@Composable
fun TestDetailScreen(
    lessonId: Int = 0,
    onFinished: () -> Unit = {}
) {
    val context = LocalContext.current
    val questions = remember { LessonQuestions.getQuestionsForLesson(lessonId) }
    var currentIndex by remember { mutableStateOf(0) }
    var selectedAnswer by remember { mutableStateOf<Int?>(null) }
    var score by remember { mutableStateOf(0) }
    var isFinished by remember { mutableStateOf(false) }
    var showResult by remember { mutableStateOf(false) }

    if (isFinished) {
        TestResultScreen(
            score = score,
            total = questions.size,
            lessonId = lessonId,
            onFinished = onFinished
        )
        return
    }

    val strings = LocalStrings.current
    val lang = loadLocale(context)
    val question = questions[currentIndex]

    val questionText = when (lang) {
        "tk" -> question.questionTm ?: question.question
        "ru" -> question.questionRu ?: question.question
        else -> question.question
    }
    val optionsList = when (lang) {
        "tk" -> question.optionsTm ?: question.options
        "ru" -> question.optionsRu ?: question.options
        else -> question.options
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.secondary)
            .padding(16.dp)
    ) {
        // Header
        Text(
            text = "${strings.lessonTest} #${lessonId + 1}",
            style = MaterialTheme.typography.titleSmall,
            color = BluePrimary,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(Modifier.height(8.dp))

        // Progress bar
        LinearProgressIndicator(
            progress = (currentIndex + 1).toFloat() / questions.size,
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .clip(RoundedCornerShape(4.dp)),
            color = BluePrimary,
            trackColor = MaterialTheme.colorScheme.tertiary
        )

        Spacer(Modifier.height(6.dp))

        Text(
            text = strings.questionNo(currentIndex + 1, questions.size),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.surface.copy(0.6f)
        )

        Spacer(Modifier.height(24.dp))

        // Question
        Text(
            text = questionText,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.surface,
            lineHeight = 24.sp
        )

        Spacer(Modifier.height(24.dp))

        // Answer options
        optionsList.forEachIndexed { index, option ->
            val bgColor = when {
                selectedAnswer == null -> MaterialTheme.colorScheme.tertiary
                index == question.correctAnswer -> Color(0xFF4CAF50)
                index == selectedAnswer -> Color(0xFFF44336)
                else -> MaterialTheme.colorScheme.tertiary
            }
            val textColor = when {
                selectedAnswer != null && (index == question.correctAnswer || index == selectedAnswer) -> Color.White
                else -> MaterialTheme.colorScheme.surface
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp)
                    .clickable(enabled = selectedAnswer == null) {
                        selectedAnswer = index
                        if (index == question.correctAnswer) score++
                        showResult = true
                    },
                colors = CardDefaults.cardColors(containerColor = bgColor),
                shape = RoundedCornerShape(12.dp),
                elevation = CardDefaults.cardElevation(2.dp)
            ) {
                Text(
                    text = option,
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.bodyLarge,
                    color = textColor
                )
            }
        }

        Spacer(Modifier.weight(1f))

        // Next button
        if (showResult) {
            Button(
                onClick = {
                    if (currentIndex < questions.size - 1) {
                        currentIndex++
                        selectedAnswer = null
                        showResult = false
                    } else {
                        isFinished = true
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                colors = ButtonDefaults.buttonColors(containerColor = BluePrimary),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = if (currentIndex < questions.size - 1) strings.nextLesson.let { "→" } else "✓",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

// Keep legacy list for backward compat
val pythonQuestions = LessonQuestions.getQuestionsForLesson(0)
