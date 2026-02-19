package com.example.pythonlearning.presentation

import android.net.Uri
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cafe.adriel.lyricist.Lyricist
import com.example.pythonlearning.locale.Strings
import com.example.pythonlearning.presentation.lesson.LessonDetailScreen
import com.example.pythonlearning.presentation.lesson.LessonsScreen
import com.example.pythonlearning.presentation.pythonTest.TestDetailScreen
import com.example.pythonlearning.presentation.pythonTest.TestsScreen
import com.example.pythonlearning.presentation.tasks.PdfViewerScreen
import com.example.pythonlearning.presentation.tasks.TaskDetailScreen
import com.example.pythonlearning.presentation.tasks.TasksScreen
import com.example.pythonlearning.ui.theme.SecondaryBg

@Composable
fun MainScreen(lyricist: Lyricist<Strings>) {
    val navController = rememberNavController()

    Scaffold(
        containerColor = SecondaryBg,
        bottomBar = {
            BottomBar(navController)
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = "lessons",
            modifier = Modifier.padding(padding)
        ) {
            composable("lessons") { LessonsScreen(navController) }
            composable("tasks") {
                TasksScreen(
                    onTaskClick = { task ->
                        navController.navigate("task_detail/${task.id}")
                    },
                    onOpenBook = {
                        navController.navigate("pdf_viewer")
                    }
                )
            }
            composable("playground") { PlaygroundScreen() }
            composable("tests") { TestsScreen(navController, lyricist) }

            composable("lesson_detail/{lessonId}") { backStackEntry ->
                val lessonId = backStackEntry.arguments?.getString("lessonId")?.toInt() ?: 0
                LessonDetailScreen(lessonId)
            }

            composable("task_detail/{taskId}") { backStackEntry ->
                val taskId = backStackEntry.arguments?.getString("taskId")?.toInt() ?: 0
                TaskDetailScreen(taskId)
            }

            composable("test_detail") {
                TestDetailScreen {
                    navController.navigate("tests")
                }
            }
            composable("pdf_viewer") {
                PdfViewerScreen(
                    pdfFileName = "python_crash_course.pdf",
                    onBack = { navController.popBackStack() }
                )
            }
        }
    }
}

//@Composable
//fun BottomBar(x0: NavHostController) {
//    TODO("Not yet implemented")
//}
