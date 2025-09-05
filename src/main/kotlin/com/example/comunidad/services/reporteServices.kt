package com.example.comunidad.services

import com.example.comunidad.models.dataClass.Reporte
import com.example.comunidad.repositories.ReporteRepository
import com.example.comunidad.models.DTO.CrearReporteDTO
import com.example.comunidad.models.DTO.ReporteConUsuarioDTO

import org.springframework.stereotype.Service

@Service
class ReporteService(
    private val reporteRepository: ReporteRepository
) {

    fun listarReportes(): List<Reporte> {
        return reporteRepository.listarReportes()
    }

    fun buscarReportePorEmail(email: String): List<ReporteConUsuarioDTO> {
        return reporteRepository.buscarReportePorEmail(email)
    }

    fun crearReporte(dto: CrearReporteDTO) {
        reporteRepository.crearReporte(dto)
    }

}
