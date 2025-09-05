package com.example.comunidad.models.DTO

import java.time.LocalDateTime

data class SolicitudConUsuarioDTO(
    val idSolicitud: Long,
    val categoriaSolicitud: String,
    val descripcion: String,
    val fechaCreacionS: LocalDateTime?,
    val idUsuario: Long,
    val emailUsuario: String
)
