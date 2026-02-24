package com.example.pythonlearning.presentation.lesson

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pythonlearning.LocalStrings
import com.example.pythonlearning.data.Lesson
import com.example.pythonlearning.data.LessonBody
import com.example.pythonlearning.data.LessonX
import com.example.pythonlearning.presentation.pythonTest.loadLocale
import com.example.pythonlearning.rememberStrings
import kotlinx.serialization.json.Json

@Composable
fun LessonsScreen(navController: NavController) {
    val context = LocalContext.current
    val lyricist = LocalStrings.current
    val lessons = remember { optLesson(context) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)

    ) {
        Text(lyricist.pythonLessons,
            style = MaterialTheme.typography.headlineSmall.copy(color = Color.Black),
            color = Color.Black)

        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn {
            items(lessons) { lesson ->
                LessonCard(lesson) {
                    navController.navigate("lesson_detail/${lesson.id}")
                }
            }
        }
    }
}

fun loadLessonsFromAssets(context: Context): List<LessonX> {
    val jsonString = context.assets.open("lessons.json")
        .bufferedReader()
        .use { it.readText() }
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

                LessonBody(
                    subtitle = subtitle,
                    subdescription = subdescription,
                    code = bodyX.code
                )
            }
        )
    }
}



@Composable
fun LessonCard(lesson: Lesson, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .padding(vertical = 8.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        colors = CardColors(
            contentColor = Color(0xff000000),
            containerColor = Color(0xffffffff),
            disabledContentColor = Color(0xff000000),
            disabledContainerColor = Color(0xffffffff)
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(lesson.title, style = MaterialTheme.typography.titleLarge.copy(color = Color.Black), color = Color.Black)
            Text(lesson.description, style = MaterialTheme.typography.bodyMedium.copy(color = Color.Black), color = Color.Black)

            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}
