package com.example.kpiz.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "todo_table")
 data class Task_Models(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "note") val note: String?,
    @ColumnInfo(name = "date") val date: String
) : Serializable
