package com.example.comunidad.models.dataClass

data class User (
        val id: Long,
        val nombresCompletos: String,
        val email: String,
        val idrole: Long,
        val iduserStatus: Long
    )