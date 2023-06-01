package com.ingmicha.android.compose.example.presentation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.ingmicha.android.compose.core.data.Note
import com.ingmicha.android.compose.example.framework.NoteViewModel

@Composable
fun NoteScreen(noteViewModel: NoteViewModel, id: Long = 0L) {

    val currentNote by noteViewModel.currentNote.observeAsState(null)
    val saved by noteViewModel.saved.observeAsState(false)
    val delete by noteViewModel.delete.observeAsState(false)

    if (id != 0L) {
        noteViewModel.getNote(id = id)
    }

    if (saved) {
        Log.i("NoteScreen", "Note Saved!!")
    } else {
        Log.e("NoteScreen", "Error, something went wrong, please try again!!")
    }

    if (delete) {
        Log.i("NoteScreen", "Note Saved!!")
    } else {
        Log.e("NoteScreen", "Error, something went wrong, please try again!!")
    }

    if (currentNote != null) {
        Log.i("NoteScreen", "$currentNote")
    }
}

fun saveNote(noteViewModel: NoteViewModel, note: Note) {
    val time = System.currentTimeMillis()
    note.title = "title"
    note.content = "content"
    note.updateTime = time
    if (note.id == 0L) {
        note.creationTime = time
    }
    noteViewModel.saveNote(note = note!!)
}

fun deleteNote(viewModel: NoteViewModel, note: Note) {
    viewModel.deleteNote(note = note)
}
