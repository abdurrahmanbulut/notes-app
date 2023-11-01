package com.abdurrahmanbulut.justroom.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import com.abdurrahmanbulut.justroom.NoteViewModel

@Composable
fun NoteScreen() {

        val viewModelStoreOwner = checkNotNull(LocalViewModelStoreOwner.current) {
            "No ViewModelStoreOwner was provided via LocalViewModelStoreOwner"
        }

        val viewModel = ViewModelProvider(owner = viewModelStoreOwner)[NoteViewModel::class.java]
        val allNotes by viewModel.allNotes.observeAsState(listOf())

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            NoteInput(viewModel = viewModel)
            Spacer(modifier = Modifier.height(8.dp))
            NoteList(notes = allNotes, onDeleteClick = { note ->
                viewModel.delete(note)
            })
        }
}