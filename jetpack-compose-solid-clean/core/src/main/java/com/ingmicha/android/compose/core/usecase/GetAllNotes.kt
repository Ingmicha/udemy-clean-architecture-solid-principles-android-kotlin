package com.ingmicha.android.compose.core.usecase

import com.ingmicha.android.compose.core.repository.NoteRepository

class GetAllNotes(private val noteRepository: NoteRepository) {
    suspend operator fun invoke() = noteRepository.getAllNotes()
}