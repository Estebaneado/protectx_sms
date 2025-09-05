package com.example.demo.service

import com.example.demo.model.Rol
import com.example.demo.repository.RolRepository
import org.springframework.stereotype.Service

@Service
class RolService(
    private val rolRepository: RolRepository
) {
    fun getAllRoles(): List<Rol> = rolRepository.findAll()

    fun getRolById(id: Long): Rol? = rolRepository.findById(id).orElse(null)

    fun createRol(rol: Rol): Rol = rolRepository.save(rol)

    fun updateRol(id: Long, rol: Rol): Rol? {
        val existingRol = rolRepository.findById(id).orElse(null) ?: return null
        existingRol.nombre = rol.nombre
        return rolRepository.save(existingRol)
    }

    fun deleteRol(id: Long): Boolean {
        return if (rolRepository.existsById(id)) {
            rolRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}
