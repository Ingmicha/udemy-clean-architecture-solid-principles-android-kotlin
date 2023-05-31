package com.ingmicha.android.compose.example.framework

import com.ingmicha.android.compose.core.usecase.AddNote
import com.ingmicha.android.compose.core.usecase.GetAllNotes
import com.ingmicha.android.compose.core.usecase.GetNote
import com.ingmicha.android.compose.core.usecase.RemoveNote

data class UseCase(
    val addNote: AddNote,
    val getAllNotes: GetAllNotes,
    val getNote: GetNote,
    val removeNote: RemoveNote
)