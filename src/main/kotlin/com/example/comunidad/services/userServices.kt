package com.example.comunidad.services

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import com.example.comunidad.models.dataClass.User
import com.example.comunidad.models.DTO.DTOcrearUser
import com.example.comunidad.repositories.UserRepository

@Service
class UserService(
    private val userRepository: UserRepository
) {
    private val passwordEncoder = BCryptPasswordEncoder()

    fun listarUsuarios(): List<User> {
        return userRepository.listarUsuarios()
    }

    fun buscarUsuario(id: String): List<User> {
        return userRepository.buscarUsuario(id)
    }

    fun crearUsuario(user: DTOcrearUser) {
        // ✅ usar la instancia que recibes, no la clase
        val hashedPassword = passwordEncoder.encode(user.contrasena)
        userRepository.crearUsuario(user, hashedPassword)
    }


}
