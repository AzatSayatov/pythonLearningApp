package com.example.pythonlearning.data

import kotlinx.serialization.Serializable

@Serializable
data class LessonX(
    val id: Int,
    val title: String,
    val titleTm: String? = null,
    val titleRu: String? = null,
    val description: String,
    val descriptionTm: String? = null,
    val descriptionRu: String? = null,
    val progress: Int,
    val text: String,
    val textTm: String? = null,
    val textRu: String? = null,
    val body: List<LessonBodyX> = emptyList()
)
@Serializable
data class LessonBodyX(
    val subtitle: String? = null,
    val subtitleTm: String? = null,
    val subtitleRu: String? = null,
    val subdescription: String? = null,
    val subdescriptionTm: String? = null,
    val subdescriptionRu: String? = null,
    val code: String? = null
)
data class Lesson(
    val id: Int,
    val title: String,
    val description: String,
    val progress: Int,
    val text: String,
    val body: List<LessonBody> = emptyList()
)
data class LessonBody(
    val subtitle: String? = null,
    val subdescription: String? = null,
    val code: String? = null
)

data class Task(
    val id: Int,
    val title: String,
    val difficulty: String,
    val solved: Boolean
)

data class TestItem(
    val id: Int,
    val title: String,
    val questionCount: Int,
    val passed: Boolean
)
