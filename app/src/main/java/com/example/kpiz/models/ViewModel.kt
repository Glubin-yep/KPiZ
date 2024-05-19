package com.example.kpiz.models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.kpiz.database.TodoDatabase
import com.example.kpiz.database.TodoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoViewModel(application: Application): AndroidViewModel(application) {
    private val repository: TodoRepository
    val allTodo : LiveData<List<TODO_Model>>

    init {
        val dao = TodoDatabase.getDatabase(application).getTodoDao()
        repository = TodoRepository(dao)
        allTodo = repository.allTodos
    }

    fun insertTodo(todo: TODO_Model) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(todo)
    }

    fun updateTodo(todo: TODO_Model) = viewModelScope.launch(Dispatchers.IO){
        repository.update(todo)
    }

    fun deleteTodo(todo: TODO_Model) = viewModelScope.launch(Dispatchers.IO){
        repository.delete(todo)
    }
}