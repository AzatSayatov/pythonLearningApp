package com.example.pythonlearning.presentation

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pythonlearning.LocalStrings
import com.example.pythonlearning.data.Lesson
import com.example.pythonlearning.presentation.lesson.LessonCard
import com.example.pythonlearning.presentation.lesson.optLesson

@Composable
fun BooksScreen(navController: NavController) {
    val context = LocalContext.current
    val lyricist = LocalStrings.current
    val listBooks = listOf(
        "Python Crash Course" to "python_crash_course.pdf",
        "Object Oriented Python" to "object_oriented_python.pdf",
        "LEARN PYTHON THE HARD WAY" to "good_learn_python.pdf",
        "Python Tutorial" to "python_tutorial.pdf",
        "Python for Everybody" to "python_for_every_body.pdf"
    )


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)

    ) {
        Text(lyricist.books,
            style = MaterialTheme.typography.headlineSmall.copy(color = Color.Black),
            color = Color.Black)

        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn {
            items(listBooks) { (title, fileName) ->
                BooksCard(
                    name = title,
                    onClick = {navController.navigate("pdf_viewer/${Uri.encode(fileName)}/${Uri.encode(title)}")}
                )
            }
        }
    }
}
@Composable
fun BooksCard(name: String, onClick: () -> Unit) {
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
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(modifier = Modifier.size(24.dp)
                    .background(color = Color.Red,
                        shape = RoundedCornerShape(4.dp)),
                    contentAlignment = Alignment.Center){
                    Text("PDF",
                        fontSize = 10.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold)
                }
                Spacer(Modifier.width(12.dp))
                Text(
                    name,
                    style = MaterialTheme.typography.titleSmall.copy(color = Color.Black),
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}