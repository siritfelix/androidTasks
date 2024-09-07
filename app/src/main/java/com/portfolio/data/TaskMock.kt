package com.portfolio.data

import com.portfolio.model.Prioridad
import com.portfolio.model.Task

object TaskMock {
    private var id = -1
    val tasks = mutableListOf(
        Task(
            id = 0,
            titulo = "Tarea 1",
            completada = false,
            prioridad = Prioridad.ALTA,
            descripcion = "Tarea mock 1",
            etiquetas = mutableListOf("etiqueta 1", "etiqueta 2"),
            asignada = "Felix Sirit"
        ),
        Task(
            id = 1,
            titulo = "Tarea 2",
            completada = false,
            prioridad = Prioridad.MEDIA,
            descripcion = "Tarea mock 2",
            etiquetas = mutableListOf("etiqueta 1", "etiqueta 2"),
            asignada = "Felix Sirit"
        ),
        Task(
            id = 2,
            titulo = "Tarea 3",
            completada = true,
            prioridad = Prioridad.BAJA,
            descripcion = "Tarea mock 3",
            etiquetas = mutableListOf("etiqueta 1", "etiqueta 2"),
            asignada = "Felix Sirit"
        ),
        Task(
            id = 3,
            titulo = "Tarea 4",
            completada = false,
            prioridad = Prioridad.ALTA,
            descripcion = "Tarea mock 4",
            etiquetas = mutableListOf("etiqueta 1", "etiqueta 2"),
            asignada = "Felix Sirit"
        ),
        Task(
            id = 4,
            titulo = "Tarea 1",
            completada = false,
            prioridad = Prioridad.ALTA,
            descripcion = "Tarea mock 1",
            etiquetas = mutableListOf("etiqueta 1", "etiqueta 2"),
            asignada = "Felix Sirit"
        ),
        Task(
            id = 5,
            titulo = "Tarea 2",
            completada = false,
            prioridad = Prioridad.MEDIA,
            descripcion = "Tarea mock 2",
            etiquetas = mutableListOf("etiqueta 1", "etiqueta 2"),
            asignada = "Felix Sirit"
        ),
        Task(
            id = 6,
            titulo = "Tarea 3",
            completada = true,
            prioridad = Prioridad.BAJA,
            descripcion = "Tarea mock 3",
            etiquetas = mutableListOf("etiqueta 1", "etiqueta 2"),
            asignada = "Felix Sirit"
        ),
        Task(
            id = 7,
            titulo = "Tarea 4",
            completada = false,
            prioridad = Prioridad.ALTA,
            descripcion = "Tarea mock 4",
            etiquetas = mutableListOf("etiqueta 1", "etiqueta 2"),
            asignada = "Felix Sirit"
        )
    )

    fun getAllTask(sord: Boolean): List<Task> {
        println("sord" + sord)
        if (sord) {
            val tasksAfter = tasks.toMutableList()
            tasksAfter.sortBy { task -> task.completada }
            return tasksAfter
        } else
            return tasks
    }

    fun getAllBFilter(proridad: Prioridad, completada: Boolean): MutableList<Task> {
        var tasksAfter = tasks
        if (proridad != null) {
            tasksAfter = tasks.filter { task -> task.prioridad == proridad }.toMutableList()
        }
        if (completada != null) {
            tasksAfter = tasks.filter { task -> task.completada == completada }.toMutableList()
        }
        return tasksAfter
    }

    fun upDateTask(task: Task): Task {
        val id = tasks.indexOfFirst { taskMock -> taskMock.id == task.id }
        if (id != -1) {
            tasks[id] = tasks[id].copy(
                titulo = task.titulo,
                completada = task.completada,
                prioridad = task.prioridad,
                descripcion = task.descripcion,
                etiquetas = task.etiquetas,
                asignada = task.asignada
            )
        }
        return tasks[id]
    }

    fun deleteTask(id: Int): Boolean {
        tasks.removeAt(id)
        return true
    }

    fun addTask(task: Task): Task {
        tasks.add(task)
        return task
    }
}