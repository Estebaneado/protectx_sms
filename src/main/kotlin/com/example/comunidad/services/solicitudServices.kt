package com.example.comunidad.services

import com.example.comunidad.models.dataClass.Solicitud
import com.example.comunidad.models.DTO.SolicitudConUsuarioDTO
import com.example.comunidad.models.DTO.CrearSolicitudDTO


import com.example.comunidad.repositories.SolicitudRepository
import org.springframework.stereotype.Service

@Service
class SolicitudService(private val solicitudRepository: SolicitudRepository) {

    fun listarSolicitudes(): List<Solicitud> {
        return solicitudRepository.listarSolicitudes()
    }

    fun buscarSolicitudPorEmail(email: String): List<SolicitudConUsuarioDTO> {
        return solicitudRepository.buscarSolicitudPorEmail(email)
    }


    fun crearSolicitud(dto: CrearSolicitudDTO) {
        solicitudRepository.crearSolicitud(dto)
    }



}
