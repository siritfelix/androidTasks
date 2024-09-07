package com.portfolio.data

import com.portfolio.model.Prioridad
import com.portfolio.model.Task

class TaskServiceImpl(private val taskMock: TaskMock) : TaskService {

    override fun getAllTask(sord: Boolean): List<Task> {
        println("Listando")
        return taskMock.getAllTask(sord)
    }

    override fun getAllBFilter(proridad: Prioridad, completada: Boolean): List<Task> {
        return taskMock.getAllBFilter(proridad, completada)
    }

    override fun upDateTask(task: Task): Task {
        println("Actualizando:" + task.toString())
        return taskMock.upDateTask(task)
    }

    override fun deleteTask(id: Int): Boolean {
        return taskMock.deleteTask(id)
    }

    override fun addTask(task: Task): Task {
        return taskMock.addTask(task)
    }
}