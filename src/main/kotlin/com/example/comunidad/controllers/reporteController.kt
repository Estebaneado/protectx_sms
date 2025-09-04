package com.example.comunidad.controllers //<------ corregir nombre del modelo aquí (creo xddd)

import org.springframework.web.bind.annotation.*
import com.example.comunidad.models.dataClass.Reporte

@RestController
@RequestMapping("/reportes")
class ReporteController {
    @GetMapping
    fun listarReportes(): List<Reporte> {
        return emptyList()
    }

    @PostMapping
    fun crearReporte(@RequestBody reporte: Reporte): Reporte {
        return reporte
    }

    @GetMapping("/{id}")
    fun obtenerReporte(@PathVariable id: Long): Reporte? {
        return null
    }

    @PutMapping("/{id}")
    fun actualizarReporte(@PathVariable id: Long, @RequestBody reporte: Reporte): Reporte {
        return reporte
    }

    @DeleteMapping("/{id}")
    fun eliminarReporte(@PathVariable id: Long): Boolean {
        return false
    }
}