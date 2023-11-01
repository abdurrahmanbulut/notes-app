package com.abdurrahmanbulut.justroom.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.RawQuery
import androidx.room.Transaction
import androidx.room.Update
import androidx.sqlite.db.SupportSQLiteQuery
import com.abdurrahmanbulut.justroom.entities.Note
import java.util.Optional

@Dao
interface NoteDao {
    @Query("SELECT * FROM notes ORDER BY timestamp DESC")
    fun getAllNotes(): LiveData<List<Note>>

    @Query("SELECT * FROM notes WHERE id = :id")
    suspend fun getNoteById(id: Int): Note?

//    @Query("SELECT * FROM notes WHERE id = :id")
//    suspend fun getNoteById(id: Int): Optional<Note>

    @Insert
    suspend fun insert(note: Note): Long

    @Update
    suspend fun update(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Query("DELETE FROM notes")
    suspend fun deleteAllNotes()

    @RawQuery
    fun customSearch(query: SupportSQLiteQuery): Note?

    @Transaction
    suspend fun deleteAndInsert(deleteNote: Note, insertNote: Note) {
        delete(deleteNote)
        insert(insertNote)
    }
}
