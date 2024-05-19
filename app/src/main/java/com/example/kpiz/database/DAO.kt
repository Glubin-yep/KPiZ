package com.example.kpiz.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kpiz.models.TODO_Model

@Dao
interface TodoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(todo: TODO_Model.Todo)

    @Delete
    suspend fun delete(todo: TODO_Model.Todo)

    @Query("SELECT * from todo_table order by id ASC")
    fun getAllTodos(): LiveData<List<TODO_Model.Todo>>

    @Query("UPDATE todo_table set title = :title, note = :note where id = :id")
    suspend fun update(id: Int?, title: String?, note: String?)
}