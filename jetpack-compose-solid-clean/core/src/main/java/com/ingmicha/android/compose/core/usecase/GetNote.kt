package com.ingmicha.android.compose.core.usecase

import com.ingmicha.android.compose.core.repository.NoteRepository

class GetNote(private val noteRepository: NoteRepository) {
    suspend operator fun invoke(id: Long) = noteRepository.getNote(id)
}