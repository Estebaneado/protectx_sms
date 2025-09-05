package com.example.comunidad.models.dataClass //<------ corregir nombre del modelo aquí (creo xddd)
import java.time.LocalDateTime

data class Reporte (
    val categoriaReporte: String,
    val quejaReporte: String,
    val iduser: Long,
    val fechaCreacionR: LocalDateTime? = null
)