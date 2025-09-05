package com.example.comunidad.services

import com.example.comunidad.models.dataClass.Rol
import org.springframework.stereotype.Service

@Service
class RolServices {
    fun listarRoles(): List<Rol> {
        return emptyList()
    }

    fun crearRol(rol: Rol): Rol {
        return rol
    }

    fun obtenerRol(id: Long): Rol? {
        return null
    }

    fun actualizarRol(id: Long, rol: Rol): Rol {
        return rol
    }

    fun eliminarRol(id: Long): Boolean {
        return false
    }
}