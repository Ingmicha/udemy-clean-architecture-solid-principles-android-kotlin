package com.ingmicha.android.compose.example.framework

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ingmicha.android.compose.core.data.Note
import com.ingmicha.android.compose.core.repository.NoteRepository
import com.ingmicha.android.compose.core.usecase.AddNote
import com.ingmicha.android.compose.core.usecase.GetAllNotes
import com.ingmicha.android.compose.core.usecase.GetNote
import com.ingmicha.android.compose.core.usecase.RemoveNote
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListViewModel(context: Context) : ViewModel() {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    private val repository = NoteRepository(RoomNoteDataSource(context))

    private val useCases = UseCases(
        AddNote(repository),
        GetAllNotes(repository),
        GetNote(repository),
        RemoveNote(repository)
    )

    val notes = MutableLiveData<List<Note>>()

    fun getNotes() {
        coroutineScope.launch {
            val noteList = useCases.getAllNotes()
            notes.postValue(noteList)
        }
    }

}