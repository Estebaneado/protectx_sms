package com.example.comunidad.models.DTO

data class DTOcrearUser (
    val nombresCompletos: String,
    val email: String,
    val contrasena: String,
    val idrole: Long,
    val iduserStatus: Long
)
