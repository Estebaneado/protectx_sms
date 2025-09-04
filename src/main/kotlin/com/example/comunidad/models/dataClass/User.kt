package com.example.comunidad.models.dataClass

data class User (
        val nombresCompletos: String,
        val email: String,
        val idrole: Long,
        val contrasena: String,
        val iduserStatus: Long
    )