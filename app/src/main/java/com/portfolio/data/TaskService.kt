package com.portfolio.data

import com.portfolio.model.Prioridad
import com.portfolio.model.Task

interface TaskService {
    fun getAllTask(sord: Boolean): List<Task>
    fun getAllBFilter(proridad: Prioridad, completada: Boolean): List<Task>
    fun upDateTask(task: Task): Task
    fun deleteTask(id: Int): Boolean
    fun addTask(task: Task): Task
}