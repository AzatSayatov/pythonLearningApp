package com.example.pythonlearning.presentation.lesson

import android.content.Context
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
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pythonlearning.LocalStrings
import com.example.pythonlearning.data.Lesson
import com.example.pythonlearning.data.LessonBody
import com.example.pythonlearning.data.LessonX
import com.example.pythonlearning.data.UserPrefs
import com.example.pythonlearning.presentation.pythonTest.loadLocale
import com.example.pythonlearning.ui.theme.BluePrimary
import kotlinx.serialization.json.Json

private val lessonIcons = listOf(
    ">_" to Color(0xFF0D9488),
    "</>" to Color(0xFF16A34A),
    "[ ]" to Color(0xFF7C3AED),
    "+-" to Color(0xFFEA580C),
    "if" to Color(0xFFDB2777),
    "↺" to Color(0xFF2563EB),
    "fx" to Color(0xFF7C3AED),
    "{ }" to Color(0xFF0D9488),
    "pkg" to Color(0xFF4F46E5),
    "I/O" to Color(0xFF0891B2),
    "try" to Color(0xFFDC2626),
    "[x]" to Color(0xFF16A34A),
    "()" to Color(0xFF9333EA),
    "str" to Color(0xFFEA580C),
    "📄" to Color(0xFF2563EB),
    "λ" to Color(0xFFDB2777),
    "@" to Color(0xFF0D9488),
    "gen" to Color(0xFF7C3AED),
    ".*" to Color(0xFFEA580C),
    "↓" to Color(0xFF16A34A),
    "⟳" to Color(0xFF2563EB),
    "with" to Color(0xFF0D9488),
    "fn" to Color(0xFF7C3AED),
    "::" to Color(0xFFDB2777),
    "C{}" to Color(0xFFEA580C),
    "{ }" to Color(0xFF2563EB),
    "f()" to Color(0xFF16A34A),
    "*" to Color(0xFF0D9488),
    "env" to Color(0xFF9333EA),
    "✓" to Color(0xFFEA580C)
)

@Composable
fun LessonsScreen(navController: NavController) {
    val context = LocalContext.current
    val lyricist = LocalStrings.current
    val lessons = remember { optLesson(context) }
    val userName = remember { com.example.pythonlearning.data.UserPrefs.getName(context) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.secondary)
    ) {
        // Top header
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
                        text = lyricist.pythonLessons,
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.surface
                    )
                    Text(
                        text = "Learn Python step by step",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.surface.copy(0.55f)
                    )
                }
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.tertiary),
                    contentAlignment = Alignment.Center
                ) {
                    Text("🐍", fontSize = 26.sp)
                }
            }
        }

        // Hero banner
        item {
            val completed = lessons.count { UserPrefs.getLessonTestScore(context, it.id) >= 70 }
            HeroBanner(
                userName = if (userName.isNotEmpty()) userName else "Developer",
                completedCount = completed,
                totalCount = lessons.size,
                onContinue = {
                    val nextUnlocked = lessons.firstOrNull { UserPrefs.isLessonUnlocked(context, it.id) && UserPrefs.getLessonTestScore(context, it.id) < 70 }
                    val dest = nextUnlocked ?: lessons.first()
                    navController.navigate("lesson_detail/${dest.id}")
                }
            )
            Spacer(Modifier.height(20.dp))
        }

        // Lessons list
        itemsIndexed(lessons) { index, lesson ->
            val isUnlocked = UserPrefs.isLessonUnlocked(context, lesson.id)
            val testScore = UserPrefs.getLessonTestScore(context, lesson.id)
            val (icon, color) = lessonIcons.getOrElse(index) { "•" to BluePrimary }
            LessonListItem(
                lesson = lesson,
                number = index + 1,
                icon = icon,
                iconColor = color,
                isUnlocked = isUnlocked,
                testScore = testScore,
                lockedLabel = lyricist.locked
            ) {
                if (isUnlocked) navController.navigate("lesson_detail/${lesson.id}")
            }
        }

        item { Spacer(Modifier.height(16.dp)) }
    }
}

@Composable
private fun HeroBanner(
    userName: String,
    completedCount: Int,
    totalCount: Int,
    onContinue: () -> Unit
) {
    val isDark = MaterialTheme.colorScheme.secondary == com.example.pythonlearning.ui.theme.DarkBg
    val bgColor = if (isDark) Color(0xFF1A2744) else Color(0xFFEEF4FF)
    val textColor = if (isDark) Color.White else Color(0xFF1A1A2E)
    val subtitleColor = if (isDark) Color(0xFFBBBBDD) else Color(0xFF4A4A6A)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = bgColor),
        elevation = CardDefaults.cardElevation(0.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Hello, $userName! 👋",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = textColor
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = "Start learning Python\nthe easy way.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = subtitleColor,
                    lineHeight = 20.sp
                )
                if (completedCount > 0) {
                    Spacer(Modifier.height(6.dp))
                    Text(
                        text = "$completedCount / $totalCount completed",
                        style = MaterialTheme.typography.labelMedium,
                        color = BluePrimary
                    )
                }
                Spacer(Modifier.height(14.dp))
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .background(BluePrimary)
                        .clickable { onContinue() }
                        .padding(horizontal = 16.dp, vertical = 10.dp)
                ) {
                    Text(
                        text = "Continue Learning →",
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 13.sp
                    )
                }
            }
            Spacer(Modifier.width(8.dp))
            Text("💻", fontSize = 60.sp)
        }
    }
}

@Composable
fun LessonListItem(
    lesson: Lesson,
    number: Int,
    icon: String,
    iconColor: Color,
    isUnlocked: Boolean,
    testScore: Int,
    lockedLabel: String,
    onClick: () -> Unit
) {
    val completed = testScore >= 70

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 5.dp)
            .alpha(if (isUnlocked) 1f else 0.55f)
            .clickable(enabled = isUnlocked) { onClick() },
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
            // Colored icon square
            Box(
                modifier = Modifier
                    .size(46.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(iconColor.copy(alpha = 0.15f)),
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

            // Title + description
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "$number. ${lesson.title}",
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.surface,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(Modifier.height(2.dp))
                Text(
                    text = lesson.description,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.surface.copy(0.55f)
                )
                // Progress bar if score exists
                if (testScore in 0..99) {
                    Spacer(Modifier.height(6.dp))
                    LinearProgressIndicator(
                        progress = testScore / 100f,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(3.dp)
                            .clip(RoundedCornerShape(2.dp)),
                        color = if (completed) Color(0xFF22C55E) else BluePrimary,
                        trackColor = Color.Gray.copy(0.2f)
                    )
                }
            }

            Spacer(Modifier.width(10.dp))

            // Status
            Column(horizontalAlignment = Alignment.End) {
                when {
                    !isUnlocked -> Text("🔒", fontSize = 16.sp)
                    completed -> {
                        Text(
                            text = "Completed",
                            color = Color(0xFF22C55E),
                            fontSize = 11.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Text("✅", fontSize = 14.sp)
                    }
                    testScore > 0 -> {
                        Text(
                            text = "$testScore%",
                            color = BluePrimary,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    else -> {
                        Text(
                            text = "0%",
                            color = MaterialTheme.colorScheme.surface.copy(0.4f),
                            fontSize = 13.sp
                        )
                    }
                }
            }

            Spacer(Modifier.width(6.dp))
            Text(
                text = "›",
                fontSize = 22.sp,
                color = MaterialTheme.colorScheme.surface.copy(0.4f),
                fontWeight = FontWeight.Light
            )
        }
    }
}

// Keep old LessonCard for compat
@Composable
fun LessonCard(lesson: Lesson, onClick: () -> Unit) {}

fun loadLessonsFromAssets(context: Context): List<LessonX> {
    val jsonString = context.assets.open("lessons.json").bufferedReader().use { it.readText() }
    return Json.decodeFromString(jsonString)
}

fun optLesson(context: Context): List<Lesson> {
    val lessons = loadLessonsFromAssets(context)
    val code = loadLocale(context)
    return lessons.map { lessonX ->
        val title = when (code) {
            "tk" -> lessonX.titleTm ?: lessonX.title
            "ru" -> lessonX.titleRu ?: lessonX.title
            else -> lessonX.title
        }
        val description = when (code) {
            "tk" -> lessonX.descriptionTm ?: lessonX.description
            "ru" -> lessonX.descriptionRu ?: lessonX.description
            else -> lessonX.description
        }
        val text = when (code) {
            "tk" -> lessonX.textTm ?: lessonX.text
            "ru" -> lessonX.textRu ?: lessonX.text
            else -> lessonX.text
        }
        Lesson(
            id = lessonX.id,
            title = title,
            description = description,
            progress = lessonX.progress,
            text = text,
            body = lessonX.body.map { bodyX ->
                val subtitle = when (code) {
                    "tk" -> bodyX.subtitleTm ?: bodyX.subtitle
                    "ru" -> bodyX.subtitleRu ?: bodyX.subtitle
                    else -> bodyX.subtitle
                }
                val subdescription = when (code) {
                    "tk" -> bodyX.subdescriptionTm ?: bodyX.subdescription
                    "ru" -> bodyX.subdescriptionRu ?: bodyX.subdescription
                    else -> bodyX.subdescription
                }
                LessonBody(subtitle = subtitle, subdescription = subdescription, code = bodyX.code)
            }
        )
    }
}
