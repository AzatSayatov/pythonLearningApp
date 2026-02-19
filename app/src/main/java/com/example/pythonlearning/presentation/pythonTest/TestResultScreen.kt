package com.example.pythonlearning.presentation.pythonTest

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pythonlearning.LocalStrings
import com.example.pythonlearning.ui.theme.BluePrimary

@Composable
fun TestResultScreen(score: Int, total: Int,onFinished: () -> Unit = {}) {
    val percentage = (score.toFloat() / total * 100).toInt()
    val context = LocalContext.current
    val strings = LocalStrings.current

    Column(verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.secondary)
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = if (percentage >= 70) strings.good else strings.readMore,
                style = MaterialTheme.typography.headlineLarge,
                color = Color.Black
            )

            Spacer(Modifier.height(24.dp))

            Text(
                text = "$score / $total",
                style = MaterialTheme.typography.displayMedium,
                color = BluePrimary,
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.height(8.dp))

            Text(
                text = "$percentage%",
                style = MaterialTheme.typography.headlineSmall,
                color = Color.Black
            )

            Spacer(Modifier.height(32.dp))

            Text(
                text = when {
                    percentage >= 90 -> strings.pythonD1
                    percentage >= 70 -> strings.pythonD2
                    percentage >= 50 -> strings.pythonD3
                    else -> strings.pythonD4
                },
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(50.dp))
            Box(
                Modifier.clickable{
                    onFinished()
                    setTestPercent(percentage,
                        context = context
                    )
                }
                    .fillMaxWidth()
                    .background(color = BluePrimary,
                        shape = RoundedCornerShape(8.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text("Ok",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W400,
                    modifier = Modifier.padding(vertical = 5.dp))
            }
        }
    }
}