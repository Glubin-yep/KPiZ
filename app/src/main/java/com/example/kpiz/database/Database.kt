package com.example.kpiz.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kpiz.models.TODO_Model

const val DATABASE_NAME = "TODO_DATABASE";

@Database(entities = arrayOf(TODO_Model::class), version = 1)
abstract class TodoDatabase : RoomDatabase() {
    abstract fun getTodoDao(): TodoDao

    companion object {
        @Volatile
        private var INSTANCE: TodoDatabase? = null

        fun getDatabase(context: Context): TodoDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TodoDatabase::class.java,
                    DATABASE_NAME
                ).build()

                INSTANCE = instance
                instance
            }
        }
    }

}