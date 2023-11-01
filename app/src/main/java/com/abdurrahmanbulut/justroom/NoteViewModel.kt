package com.abdurrahmanbulut.justroom

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.abdurrahmanbulut.justroom.database.NoteDatabase
import com.abdurrahmanbulut.justroom.entities.Note
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application) {

    private val noteDao = NoteDatabase.getInstance(application).noteDao()
    var allNotes = noteDao.getAllNotes()

    fun insert(note: Note) = viewModelScope.launch {
        noteDao.insert(note)
    }

    fun update(note: Note) = viewModelScope.launch {
        noteDao.update(note)
    }

    fun delete(note: Note) = viewModelScope.launch {
        noteDao.delete(note)
    }

    fun deleteAllNotes() = viewModelScope.launch {
        noteDao.deleteAllNotes()
    }

    fun getNoteById(id: Int): LiveData<Note?> = liveData {
        emit(noteDao.getNoteById(id))
    }

}
