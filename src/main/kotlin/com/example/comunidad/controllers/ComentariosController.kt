package com.example.comunidad.controllers

import com.example.comunidad.models.DTO.CrearComentarioDTO
import com.example.comunidad.models.DTO.VerComentarioUserDTO
import com.example.comunidad.services.ComentariosService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/comentarios")
class ComentariosController(private val comentariosService: ComentariosService) {

    // Listar todos los comentarios
    @GetMapping
    fun listarComentarios(): List<VerComentarioUserDTO> {
        return comentariosService.listarComentarios()
    }

    // Buscar comentarios por email de usuario
    @GetMapping("/{email:.+}")
    fun buscarComentariosPorEmail(@PathVariable email: String): List<VerComentarioUserDTO> {
        return comentariosService.buscarComentariosPorEmail(email)
    }

    // Crear un nuevo comentario
    @PostMapping
    fun crearComentario(@RequestBody dto: CrearComentarioDTO): String {
        comentariosService.crearComentario(dto)
        return "Comentario creado con éxito"
    }
}
