package com.example.comunidad.models.DTO
import java.time.LocalDateTime

data class VerComentarioUserDTO(
    val id: Long,
    val comentario: String,
    val fechaCreacionComentario: LocalDateTime?,
    val idUser: Long?,
    val nombreUsuario: String?,
    val emailUsuario: String?
)
