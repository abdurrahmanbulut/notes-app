package com.abdurrahmanbulut.justroom.compose

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import com.abdurrahmanbulut.justroom.entities.Note

@Composable
fun NoteList(notes: List<Note>, onDeleteClick: (Note) -> Unit) {
    LazyColumn {
        items(notes) { note ->
            NoteRow(note = note, onDeleteClick)
            Divider()
        }
    }
}
