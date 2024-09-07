package com.portfolio.model

data class Task(
    val id: Int,
    val titulo: String,
    val completada: Boolean,
    val prioridad: Prioridad,
    val descripcion: String,
    val etiquetas: List<String>,
    val asignada: String
)

enum class Prioridad(val valor: String) {
    BAJA("baja"), MEDIA("media"), ALTA("alta")
}
