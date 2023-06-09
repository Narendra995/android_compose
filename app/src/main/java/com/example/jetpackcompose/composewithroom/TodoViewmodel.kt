package com.example.jetpackcompose.composewithroom

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel
@Inject
constructor(private val todoRepository: TodoRepository) : ViewModel(){

    val response:MutableState<List<Todo>> = mutableStateOf(listOf())

    fun insert(todo:Todo) = viewModelScope.launch {
        todoRepository.insert(todo)
    }
    init {
        getAllTodos()
    }

    fun getAllTodos() = viewModelScope.launch {
        todoRepository.getAllTodos()
            .catch { e->
                Log.d("main", "Exception: ${e.message} ")
            }.collect {
                response.value = it
            }
    }
}