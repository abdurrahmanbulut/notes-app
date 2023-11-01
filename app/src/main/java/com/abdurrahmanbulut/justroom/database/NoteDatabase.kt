package com.abdurrahmanbulut.justroom.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.abdurrahmanbulut.justroom.dao.NoteDao
import com.abdurrahmanbulut.justroom.entities.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object {
        @Volatile private var instance: NoteDatabase? = null

        fun getInstance(context: Context): NoteDatabase =
            instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }

//        val MIGRATION_1_2: Migration = object : Migration(1, 2) {
//            override fun migrate(database: SupportSQLiteDatabase) {
//                database.execSQL("ALTER TABLE user ADD COLUMN email TEXT")
//            }
//        }

//        addMigrations(MIGRATION_1_2)


        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context, NoteDatabase::class.java, "note.db")
                .fallbackToDestructiveMigration()
                .build()
    }
}
