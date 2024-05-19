package com.example.kpiz.database

import androidx.lifecycle.LiveData
import com.example.kpiz.models.TODO_Model

class TodoRepository(private val todoDao: TodoDao) {

    val allTodos: LiveData<List<TODO_Model.Todo>> = todoDao.getAllTodos()

    suspend fun insert(todo: TODO_Model.Todo){
        todoDao.insert(todo)
    }

    suspend fun delete(todo: TODO_Model.Todo){
        todoDao.delete(todo)
    }

    suspend fun update(todo: TODO_Model.Todo){
        todoDao.update(todo.id, todo.title, todo.note)
    }
}