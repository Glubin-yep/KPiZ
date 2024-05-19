package com.example.kpiz.database

import androidx.lifecycle.LiveData
import com.example.kpiz.models.Task_Models

class ToDoRepository(
    private val toDoDao: TodoDao
) {

    val getAllData: LiveData<List<Task_Models>> =toDoDao.getAllTodos()

    suspend fun insertData(toDoData: Task_Models) {
        toDoDao.insert(toDoData)
    }

    suspend fun update(toDoData: Task_Models){
        toDoDao.update(toDoData.id, toDoData.title, toDoData.note)
    }

    suspend fun deleteItem(toDoData: Task_Models) {
        toDoDao.delete(toDoData)
    }

}