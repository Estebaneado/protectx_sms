package com.example.comunidad.services

import com.example.comunidad.models.DTO.AuthLogin
import com.example.comunidad.repositories.AuthRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthService(private val authRepository: AuthRepository) {

    private val passwordEncoder = BCryptPasswordEncoder()

    fun login(authLogin: AuthLogin): Boolean {
        val user = authRepository.buscarPorEmail(authLogin.email)
        return user != null && passwordEncoder.matches(authLogin.contrasena, user.contrasena)
    }
}
