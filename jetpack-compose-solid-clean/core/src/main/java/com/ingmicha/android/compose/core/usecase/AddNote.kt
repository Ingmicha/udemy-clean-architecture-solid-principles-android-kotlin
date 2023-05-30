package com.ingmicha.android.compose.core.usecase

import com.ingmicha.android.compose.core.data.Note
import com.ingmicha.android.compose.core.repository.NoteRepository

class AddNote(private val noteRepository: NoteRepository) {
    suspend operator fun invoke(note: Note) = noteRepository.addNote(note)
}