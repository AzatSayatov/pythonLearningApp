package com.example.pythonlearning.locale

import androidx.annotation.Keep
import cafe.adriel.lyricist.LyricistStrings
import kotlin.String

@Keep
data class Strings(
    val run: String,
    val result: String,
    val running: String,
    val pythonLessons: String,
    val lessons: String,
    val tasks: String,
    val code: String,
    val settings: String,
    val pythonPlayground: String,
    val inputDescription: String,
    val input: String,
    val language: String,
    val changeLanguage: String,
    val test: String,
    val lastTest: String,
    val good: String,
    val readMore: String,
    val pythonD1: String,
    val pythonD2: String,
    val pythonD3: String,
    val pythonD4: String,
    val questionNo :( index: Int,count: Int) -> String,
    val practiceTasks: String,
    val taskDescription: String,
    val hint: String,
    val books: String
)


@LyricistStrings(languageTag = Locales.RU, default = false)
val RuStrings = Strings(
    run = "Запустить",
    result = "Результат",
    running = "Выполняется",
    pythonLessons = "Уроки Python",
    lessons = "Уроки",
    tasks = "Задания",
    code = "Код",
    settings = "Настройки",
    pythonPlayground = "Python Песочница",
    inputDescription = "Введите каждую переменную с новой строки",
    input = "input line...",
    language = "Язык",
    changeLanguage = "Изменить язык",
    test = "Тест",
    lastTest = "Последние результаты теста: ",
    good = "🎉 Отлично!",
    readMore = "📚 Учись больше!",
    pythonD1 = "Ты знаешь Python отлично!",
    pythonD2 = "Хороший результат, продолжай!",
    pythonD3 = "Неплохо, но есть куда расти",
    pythonD4 = "Повтори основы Python",
    questionNo = { index, count -> "Вопрос ${index} из ${count}" },
    practiceTasks = "Практические задания",
    taskDescription = "Условие",
    hint = "Подсказка",
    books = "Книги"
)


@LyricistStrings(languageTag = Locales.EN, default = false)
val EnStrings = Strings(
    run = "Run",
    result = "Result",
    running = "Running",
    pythonLessons = "Python Lessons",
    lessons = "Lessons",
    tasks = "Tasks",
    code = "Code",
    settings = "Settings",
    pythonPlayground = "Python Playground",
    inputDescription = "Type each variable from new line",
    input = "input line...",
    language = "Language",
    changeLanguage = "Change language",
    test = "Test",
    lastTest = "Latest result of test: ",
    good = "🎉 Excellent!",
    readMore = "📚 Learn more!",
    pythonD1 = "You know Python very well!",
    pythonD2 = "Good result, keep up the good work!",
    pythonD3 = "Not bad, but there's room for improvement",
    pythonD4 = "Review the basics of Python",
    questionNo = { index, count -> "Question ${index} from ${count}" },
    practiceTasks = "Practice Tasks",
    taskDescription = "Description",
    hint = "Hint",
    books = "Books"
)

@LyricistStrings(languageTag = Locales.TM, default = true)
val TmStrings = Strings(
    run = "Işlet",
    result = "Netije",
    running = "Işleýär",
    pythonLessons = "Python Sapaklary",
    lessons = "Sapaklar",
    tasks = "Gönükmeler",
    code = "Kod",
    settings = "Sazlamalar",
    pythonPlayground = "Python Meýdançasy",
    inputDescription = "Her üýtgeýjini täze setirden ýazyň",
    input = "input line...",
    language = "Dil",
    changeLanguage = "Dil çalyşmak",
    test = "Test",
    lastTest = "Testiň soňky netijesi: ",
    good = "🎉 Ajaýyp!",
    readMore = "📚 Has giňişleýin öwreniň!",
    pythonD1 = "Pythony gaty gowy bilýärsiňiz!",
    pythonD2 = "Gowy netije, işiňizi dowam etdiriň!",
    pythonD3 = "Erbet däl, ýöne gowulaşmak üçin ýer bar",
    pythonD4 = "Pythonyň esaslaryny gözden geçiriň",
    questionNo = { index, count -> "$count soragdan $index - nji(y)" },
    practiceTasks = "Amallary ýerine ýetiriň",
    taskDescription = "Şerti",
    hint = "Kömek üçin",
    books = "Kitaplar"
)
