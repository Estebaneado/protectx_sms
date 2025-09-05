package com.example.comunidad.controllers

import com.example.comunidad.models.DTO.AuthLogin
import com.example.comunidad.services.AuthService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class AuthController(private val authService: AuthService) {

    @PostMapping("/login")
    fun login(@RequestBody authLogin: AuthLogin): String {
        return if (authService.login(authLogin)) {
            "Login exitoso"
        } else {
            "Credenciales inválidas"
        }
    }
}
