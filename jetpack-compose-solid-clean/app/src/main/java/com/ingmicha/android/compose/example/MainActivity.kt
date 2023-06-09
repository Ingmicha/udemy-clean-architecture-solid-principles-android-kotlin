package com.ingmicha.android.compose.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ingmicha.android.compose.example.framework.ListViewModel
import com.ingmicha.android.compose.example.framework.NoteViewModel
import com.ingmicha.android.compose.example.ui.theme.AppCleanTheme
import com.ingmicha.android.compose.core.data.Note
import dagger.hilt.android.AndroidEntryPoint
import java.util.Date

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val noteViewModel: NoteViewModel by viewModels()
    private val listViewModel: ListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppCleanTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val date = Date().time
                    val note = Note("Title", "content", date, date)
                    noteViewModel.saveNote(note)
                    listViewModel.getNotes()
                    listViewModel.notes
                    Column(modifier = Modifier.fillMaxSize()) {
                        Greeting("Note to save $note")
                        Greeting("Note size: ${listViewModel.notes.value?.size}")
                    }


                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "$name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppCleanTheme {
        Greeting("Android")
    }
}