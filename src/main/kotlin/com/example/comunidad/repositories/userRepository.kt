package com.example.comunidad.repositories

import com.example.comunidad.models.dataClass.User
import org.springframework.stereotype.Repository

@Repository
class UserRepository {
    fun listarUsuarios(): List<User> {
        return emptyList()
    }

    fun crearUsuario(user: User): User {
        return user
    }

    fun obtenerUsuario(id: Long): User? {
        return null
    }

    fun actualizarUsuario(id: Long, user: User): User {
        return user
    }

    fun activarUsuario(id: Long): Boolean {
        return true
    }

    fun desactivarUsuario(id: Long): Boolean {
        return true
    }
}