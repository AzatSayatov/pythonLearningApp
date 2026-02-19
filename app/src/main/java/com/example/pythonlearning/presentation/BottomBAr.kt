package com.example.pythonlearning.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.pythonlearning.LocalStrings
import com.example.pythonlearning.R
import com.example.pythonlearning.rememberStrings
import com.example.pythonlearning.ui.theme.BluePrimary

@Composable
fun BottomBar(navController: NavController) {
    val lyricist =  LocalStrings.current
    val items = listOf(
        "lessons" to lyricist.lessons,
        "tasks" to lyricist.tasks,
        "playground" to lyricist.code,
        "tests" to lyricist.settings
    )
    val icons = listOf(
        painterResource(R.drawable.ic_lessons),
        painterResource(R.drawable.ic_tasks),
        painterResource(R.drawable.ic_code),
        painterResource(R.drawable.ic_settings),
    )

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.secondary,
        contentColor = Color.Black
    ) {
        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

        items.forEachIndexed { index , (route, label) ->
            NavigationBarItem(
                selected = currentRoute == route,
                onClick = { navController.navigate(route) },
                label = { Text(label) },
                icon = { Icon(icons.get(index), contentDescription = label) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = BluePrimary,
                    selectedTextColor = BluePrimary,
                    unselectedIconColor = Color.Gray,
                    unselectedTextColor = Color.Gray,
                    indicatorColor = Color.Transparent // убирает фон-кружок при выборе
                )
            )
        }
    }
}
