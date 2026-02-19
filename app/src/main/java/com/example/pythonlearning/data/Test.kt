package com.example.pythonlearning.data

data class Question(
    val question: String,
    val questionTm: String? = null,
    val questionRu: String? = null,
    val options: List<String>,
    val optionsTm: List<String>? = null,
    val optionsRu: List<String>? = null,
    val correctAnswer: Int // индекс правильного ответа
)