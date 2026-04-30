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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.lyricist.Lyricist
import com.example.pythonlearning.LocalStrings
import com.example.pythonlearning.data.UserPrefs
import com.example.pythonlearning.locale.Locales
import com.example.pythonlearning.locale.Strings
import com.example.pythonlearning.presentation.pythonTest.loadLocale
import com.example.pythonlearning.presentation.pythonTest.setLocaleLang
import com.example.pythonlearning.ui.theme.BluePrimary

@Composable
fun SettingsScreen(
    lyricist: Lyricist<Strings>,
    darkTheme: Boolean,
    onDarkThemeToggle: (Boolean) -> Unit
) {
    val context = LocalContext.current
    val strings = LocalStrings.current
    var showLangDialog by remember { mutableStateOf(false) }
    var showEditProfile by remember { mutableStateOf(false) }
    var showAbout by remember { mutableStateOf(false) }

    var name by remember { mutableStateOf(UserPrefs.getName(context)) }
    var surname by remember { mutableStateOf(UserPrefs.getSurname(context)) }
    var age by remember { mutableStateOf(UserPrefs.getAge(context)) }
    var reason by remember { mutableStateOf(UserPrefs.getReason(context)) }

    val langCode = loadLocale(context) ?: "en"
    val currentLangFlag = when (langCode) {
        "tk" -> "🇹🇲 Türkmen"
        "ru" -> "🇷🇺 Русский"
        else -> "🇬🇧 English"
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.secondary)
            .verticalScroll(rememberScrollState())
    ) {
        // Top bar with language flags
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = strings.settings,
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.surface,
                fontWeight = FontWeight.Bold
            )
            Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                FlagButton(flag = "🇹🇲", selected = langCode == "tk") {
                    lyricist.languageTag = Locales.TM
                    setLocaleLang("tk", context)
                }
                FlagButton(flag = "🇬🇧", selected = langCode == "en") {
                    lyricist.languageTag = Locales.EN
                    setLocaleLang("en", context)
                }
                FlagButton(flag = "🇷🇺", selected = langCode == "ru") {
                    lyricist.languageTag = Locales.RU
                    setLocaleLang("ru", context)
                }
            }
        }

        Spacer(Modifier.height(8.dp))

        // Profile card
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(MaterialTheme.colorScheme.tertiary)
                .padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .size(56.dp)
                        .clip(CircleShape)
                        .background(BluePrimary),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = name.firstOrNull()?.uppercaseChar()?.toString() ?: "?",
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(start = 12.dp)
                        .weight(1f)
                ) {
                    Text(
                        text = "$name $surname",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.surface,
                        fontWeight = FontWeight.SemiBold
                    )
                    if (age.isNotEmpty()) {
                        Text(
                            text = "${strings.age}: $age",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.surface.copy(alpha = 0.6f)
                        )
                    }
                }
                // Edit button
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(BluePrimary.copy(alpha = 0.12f))
                        .clickable { showEditProfile = true }
                        .padding(horizontal = 10.dp, vertical = 6.dp)
                ) {
                    Text(
                        text = "✏ ${strings.editProfile}",
                        color = BluePrimary,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
            if (reason.isNotEmpty()) {
                Spacer(Modifier.height(12.dp))
                Text(
                    text = "\"$reason\"",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.surface.copy(alpha = 0.7f),
                    fontStyle = FontStyle.Italic
                )
            }
        }

        Spacer(Modifier.height(16.dp))

        // Settings items
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(MaterialTheme.colorScheme.tertiary)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("🌙  ", fontSize = 18.sp)
                    Text(
                        text = strings.darkMode,
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.surface
                    )
                }
                Switch(
                    checked = darkTheme,
                    onCheckedChange = onDarkThemeToggle,
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.White,
                        checkedTrackColor = BluePrimary
                    )
                )
            }

            Divider()

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { showLangDialog = true }
                    .padding(horizontal = 16.dp, vertical = 14.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("🌐  ", fontSize = 18.sp)
                    Text(
                        text = strings.language,
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.surface
                    )
                }
                Text(
                    text = currentLangFlag,
                    style = MaterialTheme.typography.bodyMedium,
                    color = BluePrimary
                )
            }
        }

        Spacer(Modifier.height(16.dp))

        // About App card
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(MaterialTheme.colorScheme.tertiary)
                .clickable { showAbout = !showAbout }
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 14.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("📱  ", fontSize = 18.sp)
                    Column {
                        Text(
                            text = strings.aboutApp,
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.surface
                        )
                        Text(
                            text = strings.appVersion,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.surface.copy(0.5f)
                        )
                    }
                }
                Text(
                    text = if (showAbout) "▲" else "▼",
                    color = MaterialTheme.colorScheme.surface.copy(0.4f),
                    fontSize = 12.sp
                )
            }

            if (showAbout) {
                Divider()
                AboutContent()
            }
        }

        Spacer(Modifier.height(32.dp))
    }

    // Edit profile dialog
    if (showEditProfile) {
        var editName by remember { mutableStateOf(name) }
        var editSurname by remember { mutableStateOf(surname) }
        var editAge by remember { mutableStateOf(age) }
        var editReason by remember { mutableStateOf(reason) }

        AlertDialog(
            containerColor = MaterialTheme.colorScheme.tertiary,
            onDismissRequest = { showEditProfile = false },
            title = {
                Text(
                    text = strings.editProfile,
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.surface,
                    fontWeight = FontWeight.Bold
                )
            },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    OutlinedTextField(
                        value = editName,
                        onValueChange = { editName = it },
                        label = { Text(strings.name) },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                    OutlinedTextField(
                        value = editSurname,
                        onValueChange = { editSurname = it },
                        label = { Text(strings.surname) },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                    OutlinedTextField(
                        value = editAge,
                        onValueChange = { if (it.length <= 3) editAge = it.filter { c -> c.isDigit() } },
                        label = { Text(strings.age) },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier.fillMaxWidth()
                    )
                    OutlinedTextField(
                        value = editReason,
                        onValueChange = { editReason = it },
                        label = { Text(strings.reasonForPython) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        maxLines = 3
                    )
                }
            },
            confirmButton = {
                TextButton(onClick = {
                    if (editName.isNotBlank() && editSurname.isNotBlank() && editAge.isNotBlank()) {
                        UserPrefs.saveProfile(context, editName, editSurname, editAge, editReason)
                        name = editName
                        surname = editSurname
                        age = editAge
                        reason = editReason
                        showEditProfile = false
                    }
                }) {
                    Text("Save", color = BluePrimary, fontWeight = FontWeight.Bold)
                }
            },
            dismissButton = {
                TextButton(onClick = { showEditProfile = false }) {
                    Text("Cancel", color = MaterialTheme.colorScheme.surface.copy(0.6f))
                }
            }
        )
    }

    // Language dialog
    if (showLangDialog) {
        AlertDialog(
            containerColor = MaterialTheme.colorScheme.tertiary,
            onDismissRequest = { showLangDialog = false },
            confirmButton = {},
            title = {
                Text(
                    text = strings.changeLanguage,
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.surface
                )
            },
            text = {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    LangDialogItem("🇹🇲", "Türkmen", langCode == "tk") {
                        lyricist.languageTag = Locales.TM
                        setLocaleLang("tk", context)
                        showLangDialog = false
                    }
                    LangDialogItem("🇬🇧", "English", langCode == "en") {
                        lyricist.languageTag = Locales.EN
                        setLocaleLang("en", context)
                        showLangDialog = false
                    }
                    LangDialogItem("🇷🇺", "Русский", langCode == "ru") {
                        lyricist.languageTag = Locales.RU
                        setLocaleLang("ru", context)
                        showLangDialog = false
                    }
                }
            }
        )
    }
}

@Composable
private fun AboutContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 14.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // App banner
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("🐍", fontSize = 36.sp)
            Spacer(Modifier.width(12.dp))
            Column {
                Text(
                    text = "PyLearn",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.surface,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Python Learning App · v1.0.0",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.surface.copy(0.5f)
                )
            }
        }

        Divider()

        Text(
            text = "PyLearn helps you master Python from the very basics to advanced topics. " +
                    "Go through structured lessons, test your knowledge, and sharpen your skills " +
                    "with hands-on coding tasks — all in one place.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.surface.copy(0.75f),
            lineHeight = 20.sp
        )

        Divider()

        // Feature list
        Text(
            text = "What's inside",
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.surface.copy(0.5f),
            fontWeight = FontWeight.SemiBold
        )
        AboutFeature("📚", "30 structured Python lessons")
        AboutFeature("✅", "Per-lesson tests with 10 questions each")
        AboutFeature("💪", "30 coding tasks across 3 difficulty levels")
        AboutFeature("⚡", "Live Python code playground")
        AboutFeature("🔒", "Progress-based lesson unlocking (70% to pass)")
        AboutFeature("🌐", "3 languages: English, Русский, Türkmen")
        AboutFeature("🌙", "Light & dark theme support")

        Divider()

        // Tech info
        Text(
            text = "Built with",
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.surface.copy(0.5f),
            fontWeight = FontWeight.SemiBold
        )
        AboutFeature("🤖", "Kotlin + Jetpack Compose")
        AboutFeature("🐍", "Chaquopy — Python 3.10 on Android")
        AboutFeature("🎨", "Material Design 3")

        Divider()

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Made with ❤ · 2025",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.surface.copy(0.4f)
            )
        }
    }
}

@Composable
private fun AboutFeature(icon: String, text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(icon, fontSize = 16.sp)
        Spacer(Modifier.width(8.dp))
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.surface.copy(0.8f)
        )
    }
}

@Composable
private fun Divider() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(0.5.dp)
            .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.1f))
    )
}

@Composable
private fun FlagButton(flag: String, selected: Boolean, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(36.dp)
            .clip(CircleShape)
            .background(if (selected) BluePrimary.copy(0.15f) else Color.Transparent)
            .border(1.dp, if (selected) BluePrimary else Color.Transparent, CircleShape)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(flag, fontSize = 20.sp)
    }
}

@Composable
private fun LangDialogItem(flag: String, label: String, selected: Boolean, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(if (selected) BluePrimary.copy(0.15f) else Color.Transparent)
            .clickable { onClick() }
            .padding(horizontal = 12.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(flag, fontSize = 22.sp)
        Text(
            text = "  $label",
            fontSize = 16.sp,
            color = if (selected) BluePrimary else MaterialTheme.colorScheme.surface,
            fontWeight = if (selected) FontWeight.SemiBold else FontWeight.Normal
        )
    }
}
