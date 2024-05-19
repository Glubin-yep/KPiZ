package com.example.kpiz.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

class TODO_Model {
    @Entity(tableName = "todo_table")
    data class Todo(
        @PrimaryKey(autoGenerate = true) val id: Int?,
        @ColumnInfo(name = "title") val title: String?,
        @ColumnInfo(name = "note") val note: String?,
        @ColumnInfo(name = "date") val date: String
    ): java.io.Serializable
}