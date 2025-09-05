package com.example.comunidad.services

import com.example.comunidad.models.DTO.CrearComentarioDTO
import com.example.comunidad.models.DTO.VerComentarioUserDTO
import com.example.comunidad.repositories.ComentariosRepository
import org.springframework.stereotype.Service

@Service
class ComentariosService(private val comentariosRepository: ComentariosRepository) {

    // Listar todos los comentarios con info de usuario
    fun listarComentarios(): List<VerComentarioUserDTO> {
        return comentariosRepository.listarComentarios()
    }

    // Buscar comentarios por email de usuario
    fun buscarComentariosPorEmail(email: String): List<VerComentarioUserDTO> {
        return comentariosRepository.buscarComentariosPorEmail(email)
    }

    // Crear un comentario usando DTO
    fun crearComentario(dto: CrearComentarioDTO): Int {
        return comentariosRepository.crearComentario(dto)
    }
}
