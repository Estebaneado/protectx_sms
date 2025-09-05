package com.example.comunidad.models.DTO
import java.time.LocalDateTime
data class ReporteConUsuarioDTO(
    val idReporte: Long,
    val categoriaReporte: String,
    val quejaReporte: String,
    val fechaCreacionR: LocalDateTime?,
    val nombreUsuario: String,
    val emailUsuario: String
)
