package com.example.comunidad.repositories //<------ corregir nombre del modelo aquí (creo xddd)

import com.example.comunidad.models.dataClass.Reporte
import org.springframework.stereotype.Repository

@Repository
class ReporteRepository {
    fun listarReportes(): List<Reporte> {
        return emptyList()
    }

    fun crearReporte(reporte: Reporte): Reporte {
        return reporte
    }

    fun obtenerReporte(id: Long): Reporte? {
        return null
    }

    fun actualizarReporte(id: Long, reporte: Reporte): Reporte {
        return reporte
    }

    fun eliminarReporte(id: Long): Boolean {
        return false
    }
}
