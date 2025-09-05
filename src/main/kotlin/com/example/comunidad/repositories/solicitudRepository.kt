package com.example.comunidad.repositories

import com.example.comunidad.models.dataClass.Solicitud
import org.springframework.stereotype.Repository

@Repository
class SolicitudRepository {
    fun listarSolicitudes(): List<Solicitud> {
        return emptyList()
    }

    fun crearSolicitud(solicitud: Solicitud): Solicitud {
        return solicitud
    }

    fun obtenerSolicitud(id: Long): Solicitud? {
        return null
    }

    fun actualizarSolicitud(id: Long, solicitud: Solicitud): Solicitud {
        return solicitud
    }

    fun eliminarSolicitud(id: Long): Boolean {
        return false
    }
}