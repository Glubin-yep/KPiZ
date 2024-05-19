package com.example.kpiz.database

import androidx.lifecycle.LiveData
import com.example.kpiz.models.TODO_Model

class TodoRepository(private val todoDao: TodoDao) {

    val allTodos: LiveData<List<TODO_Model>> = todoDao.getAllTodos()

    suspend fun insert(todo: TODO_Model){
        todoDao.insert(todo)
    }

    suspend fun delete(todo: TODO_Model){
        todoDao.delete(todo)
    }

    suspend fun update(todo: TODO_Model){
        todoDao.update(todo.id, todo.title, todo.note)
    }
}