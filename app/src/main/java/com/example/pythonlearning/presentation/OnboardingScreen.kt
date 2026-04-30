package com.example.pythonlearning.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pythonlearning.LocalStrings
import com.example.pythonlearning.data.UserPrefs
import com.example.pythonlearning.ui.theme.BluePrimary

@Composable
fun OnboardingScreen(onComplete: (lang: String) -> Unit) {
    val context = LocalContext.current
    val strings = LocalStrings.current

    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var reason by remember { mutableStateOf("") }
    var selectedLang by remember { mutableStateOf("en") }
    var showError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.secondary)
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(48.dp))

        Text(
            text = "🐍",
            fontSize = 64.sp
        )

        Spacer(Modifier.height(16.dp))

        Text(
            text = strings.welcomeTitle,
            style = MaterialTheme.typography.headlineMedium,
            color = BluePrimary,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(8.dp))

        Text(
            text = strings.welcomeSubtitle,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.surface.copy(alpha = 0.7f)
        )

        Spacer(Modifier.height(32.dp))

        // Language selector
        Text(
            text = strings.selectLanguage,
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.surface,
            modifier = Modifier.align(Alignment.Start)
        )
        Spacer(Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            LangFlagButton(flag = "🇹🇲", label = "Türkmen", selected = selectedLang == "tk", modifier = Modifier.weight(1f)) {
                selectedLang = "tk"
            }
            LangFlagButton(flag = "🇬🇧", label = "English", selected = selectedLang == "en", modifier = Modifier.weight(1f)) {
                selectedLang = "en"
            }
            LangFlagButton(flag = "🇷🇺", label = "Русский", selected = selectedLang == "ru", modifier = Modifier.weight(1f)) {
                selectedLang = "ru"
            }
        }

        Spacer(Modifier.height(24.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(strings.name) },
            placeholder = { Text(strings.yourName, color = MaterialTheme.colorScheme.surface.copy(0.5f)) },
            modifier = Modifier.fillMaxWidth(),
            isError = showError && name.isBlank(),
            singleLine = true
        )

        Spacer(Modifier.height(12.dp))

        OutlinedTextField(
            value = surname,
            onValueChange = { surname = it },
            label = { Text(strings.surname) },
            placeholder = { Text(strings.yourSurname, color = MaterialTheme.colorScheme.surface.copy(0.5f)) },
            modifier = Modifier.fillMaxWidth(),
            isError = showError && surname.isBlank(),
            singleLine = true
        )

        Spacer(Modifier.height(12.dp))

        OutlinedTextField(
            value = age,
            onValueChange = { if (it.length <= 3) age = it.filter { c -> c.isDigit() } },
            label = { Text(strings.age) },
            placeholder = { Text(strings.yourAge, color = MaterialTheme.colorScheme.surface.copy(0.5f)) },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            isError = showError && age.isBlank(),
            singleLine = true
        )

        Spacer(Modifier.height(12.dp))

        OutlinedTextField(
            value = reason,
            onValueChange = { reason = it },
            label = { Text(strings.reasonForPython) },
            placeholder = { Text(strings.yourReason, color = MaterialTheme.colorScheme.surface.copy(0.5f)) },
            modifier = Modifier.fillMaxWidth().height(120.dp),
            maxLines = 4
        )

        Spacer(Modifier.height(32.dp))

        if (showError && (name.isBlank() || surname.isBlank() || age.isBlank())) {
            Text(
                text = "⚠ Заполните все обязательные поля",
                color = Color(0xFFF44336),
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(bottom = 12.dp)
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .background(BluePrimary)
                .clickable {
                    if (name.isBlank() || surname.isBlank() || age.isBlank()) {
                        showError = true
                    } else {
                        UserPrefs.saveProfile(context, name, surname, age, reason)
                        onComplete(selectedLang)
                    }
                }
                .padding(vertical = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = strings.startLearning,
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )
        }

        Spacer(Modifier.height(32.dp))
    }
}

@Composable
fun LangFlagButton(flag: String, label: String, selected: Boolean, modifier: Modifier = Modifier, onClick: () -> Unit) {
    val bg = if (selected) BluePrimary.copy(alpha = 0.15f) else Color.Transparent
    val border = if (selected) BluePrimary else Color.Gray.copy(alpha = 0.4f)

    Column(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(bg)
            .border(1.dp, border, RoundedCornerShape(10.dp))
            .clickable { onClick() }
            .padding(vertical = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(flag, fontSize = 24.sp)
        Spacer(Modifier.height(4.dp))
        Text(
            text = label,
            fontSize = 11.sp,
            color = if (selected) BluePrimary else MaterialTheme.colorScheme.surface.copy(0.7f),
            fontWeight = if (selected) FontWeight.SemiBold else FontWeight.Normal
        )
    }
}
