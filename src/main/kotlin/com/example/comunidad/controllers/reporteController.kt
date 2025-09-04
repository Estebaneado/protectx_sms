package com.example.comunidad.controllers

import org.springframework.web.bind.annotation.*
import com.example.comunidad.models.dataClass.Reporte

@RestController
@RequestMapping("/reportes")
class ReporteController {

    @GetMapping
    fun listarReportes(): List<Reporte> {
        // TODO: Implementar lógica para obtener reportes
        return emptyList()
    }

    @PostMapping
    fun crearReporte(@RequestBody reporte: Reporte): Reporte {
        // TODO: Implementar lógica para crear reporte
        return reporte
    }

    @GetMapping("/{id}")
    fun obtenerReporte(@PathVariable id: Long): Reporte? {
        // TODO: Implementar lógica para obtener reporte por ID
        return null
    }

    @PutMapping("/{id}")
    fun actualizarReporte(@PathVariable id: Long, @RequestBody reporte: Reporte): Reporte {
        // TODO: Implementar lógica para actualizar reporte
        return reporte
    }

    @DeleteMapping("/{id}")
    fun eliminarReporte(@PathVariable id: Long): Boolean {
        // TODO: Implementar lógica para eliminar reporte
        return false
    }
}