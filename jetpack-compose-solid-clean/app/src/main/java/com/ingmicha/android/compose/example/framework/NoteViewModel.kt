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
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor() : ViewModel() {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    @Inject
    lateinit var useCases: UseCases

    val saved = MutableLiveData<Boolean>()
    val delete = MutableLiveData<Boolean>()
    val currentNote = MutableLiveData<Note>()

    fun saveNote(note: Note) {
        coroutineScope.launch {
            useCases.addNote(note)
            saved.postValue(true)
        }
    }

    fun getNote(id: Long) {
        coroutineScope.launch {
            val note = useCases.getNote(id)
            currentNote.postValue(note)
        }
    }

    fun deleteNote(note: Note) {
        coroutineScope.launch {
            useCases.removeNote(note)
            delete.postValue(true)
        }
    }

}