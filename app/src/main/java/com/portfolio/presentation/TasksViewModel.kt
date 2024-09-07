package com.portfolio.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.portfolio.data.TaskService
import com.portfolio.model.Task
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class TaskUiState {
    object Loading : TaskUiState()
    data class Success(
        val tasks: List<Task>, val endTotal: Int, val toDo: Int, val total: Int, val sord: Boolean
    ) : TaskUiState()

    data class Error(val message: String) : TaskUiState()
}

class TasksViewModel(private val taskService: TaskService) : ViewModel() {
    private val _uiState = MutableStateFlow<TaskUiState>(TaskUiState.Loading)
    val uiState = _uiState.asStateFlow()
    private val _sordList = MutableStateFlow(false)
    val sordList = _sordList.asStateFlow()

    init {
        viewModelScope.launch { upDateTasks() }
    }

    fun syncList() {
        viewModelScope.launch {
            _uiState.value = TaskUiState.Loading
            upDateTasks()
        }
    }

    private suspend fun upDateTasks() {
        try {
            val tasks = taskService.getAllTask(sordList.value)
            _uiState.value = TaskUiState.Success(
                tasks,
                tasks.count { task: Task -> task.completada },
                tasks.count { task: Task -> !task.completada },
                tasks.size, sord = sordList.value
            )
        } catch (e: Exception) {
            _uiState.value = TaskUiState.Error("Error al cargar tareas")
        }
    }

    fun upDateTask(task: Task) {
        viewModelScope.launch {
            try {
                taskService.upDateTask(task.copy(completada = !task.completada))
            } catch (e: Exception) {
                _uiState.value = TaskUiState.Error("Error al cargar tareas")
            }
            upDateTasks()
        }
    }

    fun sordList(sord: Boolean) {
        println(sord)
        _sordList.value = sord
        syncList()
    }
}