package com.ingmicha.android.compose.example.presentation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.ingmicha.android.compose.core.data.Note
import com.ingmicha.android.compose.example.framework.NoteViewModel

@Composable
fun NoteScreen(noteViewModel: NoteViewModel) {
    val currentNote = Note("", "", 0L, 0L)
    val saved by noteViewModel.saved.observeAsState(false)
    val saveNote = {
        val time = System.currentTimeMillis()
        currentNote.title = "title"
        currentNote.content = "content"
        currentNote.updateTime = time
        if (currentNote.id == 0L) {
            currentNote.creationTime = time
        }
        noteViewModel.saveNote(note = currentNote)
    }
    observerViewModel(saved)
}

fun observerViewModel(saved: Boolean) {
    if (saved) {
        Log.i("NoteScreen", "Note Saved!!")
    } else {
        Log.e("NoteScreen", "Error, something went wrong, please try again!!")
    }
}
