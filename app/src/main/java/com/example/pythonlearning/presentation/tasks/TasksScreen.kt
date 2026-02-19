package com.example.pythonlearning.presentation.tasks

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.pythonlearning.LocalStrings
import com.example.pythonlearning.R
import com.example.pythonlearning.data.tasks.AppLanguage
import com.example.pythonlearning.data.tasks.Difficulty
import com.example.pythonlearning.data.tasks.PythonTask
import com.example.pythonlearning.data.tasks.PythonTasks
import com.example.pythonlearning.data.tasks.localizedDescription
import com.example.pythonlearning.data.tasks.localizedTitle
import com.example.pythonlearning.presentation.pythonTest.loadLocale

@Composable
fun TasksScreen(
    onTaskClick: (PythonTask) -> Unit = {},
    onOpenBook: () -> Unit = {}
) {
    val lyricist = LocalStrings.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = lyricist.tasks,
                style = MaterialTheme.typography.headlineSmall.copy(color = Color.Black),
                color = Color.Black
            )

            IconButton(onClick = onOpenBook) {
                Icon(
                    painter = painterResource(R.drawable.outline_menu_book_24),
                    contentDescription = "Open Book",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            // Секция по каждому уровню
            Difficulty.entries.forEach { difficulty ->
                val filtered = PythonTasks.tasks.filter { it.difficulty == difficulty }

                item {
                    DifficultySection(
                        difficulty = difficulty,
                        tasks = filtered,
                        onTaskClick = onTaskClick
                    )
                }
            }
        }
    }
}

@Composable
fun DifficultySection(
    difficulty: Difficulty,
    tasks: List<PythonTask>,
    onTaskClick: (PythonTask) -> Unit
) {
    val (label, color) = when (difficulty) {
        Difficulty.BEGINNER -> "🟢 Beginner" to Color(0xFF4CAF50)
        Difficulty.INTERMEDIATE -> "🟡 Intermediate" to Color(0xFFFFC107)
        Difficulty.ADVANCED -> "🔴 Advanced" to Color(0xFFF44336)
    }

    Column {
        Text(
            text = label,
            style = MaterialTheme.typography.titleMedium.copy(color = Color.Black),
            color = color,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        tasks.forEach { task ->
            TaskCard(task = task, accentColor = color, onClick = { onTaskClick(task) })
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun TaskCard(
    task: PythonTask,
    accentColor: Color,
    onClick: () -> Unit
) {
    val context = LocalContext.current
    val langCode = loadLocale(context)
    val lang = when (langCode) {
        "ru" -> AppLanguage.RU
        "tk" -> AppLanguage.TM
        else -> AppLanguage.EN
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Цветная полоска слева
            Box(
                modifier = Modifier
                    .width(4.dp)
                    .height(48.dp)
                    .background(accentColor, RoundedCornerShape(2.dp))
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = task.localizedTitle(lang),
                    style = MaterialTheme.typography.titleSmall.copy(color = Color.Black),
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = task.localizedDescription(lang),
                    style = MaterialTheme.typography.bodySmall.copy(color = Color.Black),
                    color = Color.Black.copy(alpha = 0.7f),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = null,
                tint = accentColor
            )
        }
    }
}
