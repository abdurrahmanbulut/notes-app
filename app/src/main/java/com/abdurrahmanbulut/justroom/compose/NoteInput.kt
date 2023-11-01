package com.abdurrahmanbulut.justroom.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.abdurrahmanbulut.justroom.NoteViewModel
import com.abdurrahmanbulut.justroom.entities.Note

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteInput(viewModel: NoteViewModel) {
    var text by remember { mutableStateOf(TextFieldValue()) }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Add a note") },
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Button(
            onClick = {
                viewModel.insert(Note(content = text.text, timestamp = System.currentTimeMillis()))
                text = TextFieldValue()
            }
        ) {
            Text("Add")
        }
        Spacer(modifier = Modifier.width(8.dp))

    }
}