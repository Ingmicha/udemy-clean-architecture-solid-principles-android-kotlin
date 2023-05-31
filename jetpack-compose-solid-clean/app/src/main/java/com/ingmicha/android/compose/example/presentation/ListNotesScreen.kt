package com.ingmicha.android.compose.example.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ingmicha.android.compose.core.data.Note
import com.ingmicha.android.compose.example.framework.ListViewModel
import java.text.SimpleDateFormat
import java.util.Locale

//@Preview
@Composable
fun ListNotesScreen(listViewModel: ListViewModel) {

    listViewModel.getNotes()

    val noteList by listViewModel.notes.observeAsState(initial = emptyList())

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        ListItemNote(noteList)
    }
}

@Preview
@Composable
fun ListItemNote(noteList: List<Note> = emptyList()) {
    LazyColumn() {
        items(items = noteList) {
            ItemNote(it)
        }
    }
}

@Preview
@Composable
fun ItemNote(note: Note = Note("Title", "Content", 1685569192642, 1685569192642)) {

    val sdf = SimpleDateFormat("MMM dd, HH:mm:ss", Locale.getDefault())

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = note.title,
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                maxLines = 1
            )
            Text(
                text = note.content,
                modifier = Modifier.fillMaxWidth(),
                fontSize = 16.sp,
                maxLines = 1
            )
            Text(
                text = "Last updated: ${sdf.format(note.updateTime)}",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                fontSize = 10.sp
            )
        }
    }
}