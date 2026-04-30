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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pythonlearning.LocalStrings
import com.example.pythonlearning.data.tasks.AppLanguage
import com.example.pythonlearning.data.tasks.Difficulty
import com.example.pythonlearning.data.tasks.PythonTask
import com.example.pythonlearning.data.tasks.PythonTasks
import com.example.pythonlearning.data.tasks.localizedDescription
import com.example.pythonlearning.data.tasks.localizedTitle
import com.example.pythonlearning.presentation.pythonTest.loadLocale

// Task icon mapping: icon text + color
private val taskIcons = mapOf(
    1 to (">_" to Color(0xFF0D9488)),
    2 to ("+" to Color(0xFF16A34A)),
    3 to ("%" to Color(0xFFEA580C)),
    4 to ("▲" to Color(0xFF2563EB)),
    5 to ("×" to Color(0xFFDB2777)),
    6 to ("⊞" to Color(0xFF7C3AED)),
    7 to ("Aa" to Color(0xFF0891B2)),
    8 to ("P?" to Color(0xFFDC2626)),
    9 to ("~=" to Color(0xFF16A34A)),
    10 to ("FZ" to Color(0xFFEA580C)),
    11 to ("⬡" to Color(0xFF7C3AED)),
    12 to ("n!" to Color(0xFF2563EB)),
    13 to ("⌕" to Color(0xFF0D9488)),
    14 to ("Σ" to Color(0xFFDB2777)),
    15 to ("T" to Color(0xFF9333EA)),
    16 to ("#" to Color(0xFF0891B2)),
    17 to ("↩" to Color(0xFF16A34A)),
    18 to ("Σd" to Color(0xFFEA580C)),
    19 to ("°F" to Color(0xFF2563EB)),
    20 to ("÷" to Color(0xFFDB2777)),
    21 to ("🔑" to Color(0xFF0D9488)),
    22 to ("Vw" to Color(0xFF7C3AED)),
    23 to ("[]" to Color(0xFF0891B2)),
    24 to ("÷=" to Color(0xFFDC2626)),
    25 to ("∑∑" to Color(0xFF16A34A)),
    26 to ("↕" to Color(0xFF7C3AED)),
    27 to ("M$" to Color(0xFF2563EB)),
    28 to ("@t" to Color(0xFFDB2777)),
    29 to ("∞" to Color(0xFF0D9488)),
    30 to ("2Σ" to Color(0xFF9333EA))
)

private val difficultyConfig = mapOf(
    Difficulty.BEGINNER to Triple("🌱", "Beginner", Color(0xFF16A34A)),
    Difficulty.INTERMEDIATE to Triple("📈", "Intermediate", Color(0xFFD97706)),
    Difficulty.ADVANCED to Triple("🔥", "Advanced", Color(0xFFDC2626))
)

@Composable
fun TasksScreen(
    onTaskClick: (PythonTask) -> Unit = {},
    onOpenBook: () -> Unit = {}
) {
    val lyricist = LocalStrings.current
    val context = LocalContext.current
    val langCode = loadLocale(context)
    val lang = when (langCode) {
        "ru" -> AppLanguage.RU
        "tk" -> AppLanguage.TM
        else -> AppLanguage.EN
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.secondary)
    ) {
        // Header
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Column {
                    Text(
                        text = lyricist.tasks,
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.surface
                    )
                    Text(
                        text = "Practice and improve your skills",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.surface.copy(0.55f)
                    )
                }
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.tertiary)
                        .clickable { onOpenBook() },
                    contentAlignment = Alignment.Center
                ) {
                    Text("📚", fontSize = 22.sp)
                }
            }
        }

        // Sections by difficulty
        Difficulty.entries.forEach { difficulty ->
            val filtered = PythonTasks.tasks.filter { it.difficulty == difficulty }
            val (emoji, label, color) = difficultyConfig[difficulty]!!

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(30.dp)
                                .clip(CircleShape)
                                .background(color.copy(0.15f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(emoji, fontSize = 14.sp)
                        }
                        Spacer(Modifier.width(8.dp))
                        Text(
                            text = label,
                            style = MaterialTheme.typography.titleMedium,
                            color = color,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .background(color.copy(0.12f))
                            .padding(horizontal = 10.dp, vertical = 4.dp)
                    ) {
                        Text(
                            text = "${filtered.size} Tasks",
                            color = color,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }

            filtered.forEach { task ->
                item {
                    val (icon, iconColor) = taskIcons[task.id] ?: ("?" to color)
                    TaskListItem(
                        task = task,
                        icon = icon,
                        iconColor = iconColor,
                        accentColor = color,
                        lang = lang,
                        onClick = { onTaskClick(task) }
                    )
                }
            }

            item { Spacer(Modifier.height(8.dp)) }
        }

        item { Spacer(Modifier.height(16.dp)) }
    }
}

@Composable
fun TaskListItem(
    task: PythonTask,
    icon: String,
    iconColor: Color,
    accentColor: Color,
    lang: AppLanguage,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 4.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.tertiary),
        elevation = CardDefaults.cardElevation(0.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Icon
            Box(
                modifier = Modifier
                    .size(46.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(iconColor.copy(0.15f)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = icon,
                    color = iconColor,
                    fontSize = if (icon.length <= 2) 18.sp else 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(Modifier.width(14.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "${task.id}. ${task.localizedTitle(lang)}",
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.surface,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(Modifier.height(2.dp))
                Text(
                    text = task.localizedDescription(lang),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.surface.copy(0.55f),
                    maxLines = 2
                )
            }

            Spacer(Modifier.width(8.dp))
            Text(
                text = "›",
                fontSize = 22.sp,
                color = accentColor,
                fontWeight = FontWeight.Light
            )
        }
    }
}

// Keep for compat
@Composable
fun DifficultySection(
    difficulty: com.example.pythonlearning.data.tasks.Difficulty,
    tasks: List<PythonTask>,
    onTaskClick: (PythonTask) -> Unit
) {}

@Composable
fun TaskCard(task: PythonTask, accentColor: Color, onClick: () -> Unit) {}
