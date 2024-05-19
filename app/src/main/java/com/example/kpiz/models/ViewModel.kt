package com.example.kpiz.models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.kpiz.database.ToDoRepository
import com.example.kpiz.database.TodoDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoViewModel(application: Application): AndroidViewModel(application) {
    private val repository: ToDoRepository
    val allTodo : LiveData<List<Task_Models>>

    init {
        val dao = TodoDatabase.getDatabase(application).getTodoDao()
        repository = ToDoRepository(dao)
        allTodo = repository.getAllData
    }

    fun insertTodo(todo: Task_Models) = viewModelScope.launch(Dispatchers.IO){
        repository.insertData(todo)
    }

    fun updateTodo(todo: Task_Models) = viewModelScope.launch(Dispatchers.IO){
        repository.update(todo)
    }

    fun deleteTodo(todo: Task_Models) = viewModelScope.launch(Dispatchers.IO){
        repository.deleteItem(todo)
    }

}