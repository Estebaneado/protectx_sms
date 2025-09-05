package com.example.comunidad.controllers

import org.springframework.web.bind.annotation.*
import com.example.comunidad.models.dataClass.Reporte
import com.example.comunidad.services.ReporteService
import com.example.comunidad.models.DTO.CrearReporteDTO
import com.example.comunidad.models.DTO.ReporteConUsuarioDTO


@RestController
@RequestMapping("/reportes")
class ReporteController(
    private val reporteService: ReporteService
) {

    // Listar todos los reportes
    @GetMapping
    fun listarReportes(): List<Reporte> {
        return reporteService.listarReportes()
    }

    // Buscar reportes por email
    @GetMapping("/{email:.+}")
    fun buscarReportePorEmail(@PathVariable email: String): List<ReporteConUsuarioDTO> {
        return reporteService.buscarReportePorEmail(email)
    }

    // Crear un nuevo reporte
    @PostMapping
    fun crearReporte(@RequestBody dto: CrearReporteDTO) {
        reporteService.crearReporte(dto)
    }
}

