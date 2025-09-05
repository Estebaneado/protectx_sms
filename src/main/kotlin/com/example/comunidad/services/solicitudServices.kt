package com.example.comunidad.services

import com.example.comunidad.models.dataClass.Solicitud
import org.springframework.stereotype.Service

@Service
class SolicitudServices {
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