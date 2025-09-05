package com.example.comunidad.repositories

import com.example.comunidad.models.dataClass.UserStatus
import org.springframework.stereotype.Repository

@Repository
class UserStatusRepository {
    fun listarUserStatus(): List<UserStatus> {
        return emptyList()
    }

    fun crearUserStatus(userStatus: UserStatus): UserStatus {
        return userStatus
    }

    fun obtenerUserStatus(id: Long): UserStatus? {
        return null
    }

    fun actualizarUserStatus(id: Long, userStatus: UserStatus): UserStatus {
        return userStatus
    }

    fun eliminarUserStatus(id: Long): Boolean {
        return false
    }
}