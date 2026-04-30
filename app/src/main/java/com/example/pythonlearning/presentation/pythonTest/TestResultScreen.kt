package com.example.pythonlearning.presentation.pythonTest

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pythonlearning.LocalStrings
import com.example.pythonlearning.data.UserPrefs
import com.example.pythonlearning.ui.theme.BluePrimary

@Composable
fun TestResultScreen(
    score: Int,
    total: Int,
    lessonId: Int = -1,
    onFinished: () -> Unit = {}
) {
    val percentage = (score.toFloat() / total * 100).toInt()
    val context = LocalContext.current
    val strings = LocalStrings.current
    val passed = percentage >= 70

    // Save result
    LaunchedEffect(Unit) {
        if (lessonId >= 0) {
            val existing = UserPrefs.getLessonTestScore(context, lessonId)
            if (percentage > existing) {
                UserPrefs.setLessonTestScore(context, lessonId, percentage)
            }
        }
        setTestPercent(percentage, context)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.secondary)
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Emoji result
        Text(
            text = if (passed) "🎉" else "📚",
            fontSize = 72.sp
        )

        Spacer(Modifier.height(16.dp))

        Text(
            text = if (passed) strings.good else strings.readMore,
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.surface,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(Modifier.height(24.dp))

        // Score circle
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(100.dp))
                .background(if (passed) Color(0xFF4CAF50).copy(0.15f) else Color(0xFFF44336).copy(0.15f))
                .padding(horizontal = 32.dp, vertical = 20.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "$score / $total",
                    style = MaterialTheme.typography.displaySmall,
                    color = if (passed) Color(0xFF4CAF50) else Color(0xFFF44336),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "$percentage%",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.surface
                )
            }
        }

        Spacer(Modifier.height(24.dp))

        Text(
            text = when {
                percentage >= 90 -> strings.pythonD1
                percentage >= 70 -> strings.pythonD2
                percentage >= 50 -> strings.pythonD3
                else -> strings.pythonD4
            },
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.surface.copy(0.8f),
            textAlign = TextAlign.Center
        )

        if (passed && lessonId >= 0) {
            Spacer(Modifier.height(8.dp))
            Text(
                text = strings.lessonCompleted,
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xFF4CAF50),
                fontWeight = FontWeight.SemiBold
            )
        }

        if (!passed) {
            Spacer(Modifier.height(8.dp))
            Text(
                text = strings.passToUnlock,
                style = MaterialTheme.typography.bodySmall,
                color = Color(0xFFF44336).copy(0.8f),
                textAlign = TextAlign.Center
            )
        }

        Spacer(Modifier.height(40.dp))

        // Buttons
        if (!passed) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFFF44336))
                    .clickable { onFinished() }
                    .padding(vertical = 14.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = strings.tryAgain,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp
                )
            }
        } else {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(BluePrimary)
                    .clickable { onFinished() }
                    .padding(vertical = 14.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "OK",
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp
                )
            }
        }
    }
}
