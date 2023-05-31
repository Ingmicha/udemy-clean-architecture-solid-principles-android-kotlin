package com.ingmicha.android.compose.example.framework

import android.content.Context
import com.ingmicha.android.compose.core.data.Note
import com.ingmicha.android.compose.core.repository.NoteDataSource
import com.ingmicha.android.compose.example.framework.db.DatabaseService
import com.ingmicha.android.compose.example.framework.db.NoteEntity

class RoomNoteDataSource(context: Context) : NoteDataSource {
    val noteDao = DatabaseService.getInstance(context).noteDao()

    override suspend fun add(note: Note) {
        noteDao.addNoteEntity(NoteEntity.fromNote(note))
    }

    override suspend fun get(id: Long): Note? {
        return noteDao.getNoteEntity(id)?.toNote()
    }

    override suspend fun getAll(): List<Note> {
        return noteDao.getAllNoteEntities().map { it.toNote() }
    }

    override suspend fun remove(note: Note) {
        noteDao.deleteNoteEntity(NoteEntity.fromNote(note))
    }
}