package com.example.comunidad.models.dataClass

import java.time.LocalDateTime

data class Solicitud (
    val categoriaSolicitud: String,
    val descripcion: String,
    val iduser: Long,
    val fechaCreacionS: LocalDateTime? = null
)