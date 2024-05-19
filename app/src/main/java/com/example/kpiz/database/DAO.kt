package com.example.kpiz.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.kpiz.models.Task_Models

@Dao
interface TodoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(todo: Task_Models)

    @Delete
    fun delete(todo: Task_Models)

    @Query("SELECT * from todo_table order by id ASC")
    fun getAllTodos(): LiveData<List<Task_Models>>

    @Query("UPDATE todo_table set title = :title, note = :note where id = :id")
    fun update(id: Int?, title: String?, note: String?)
}