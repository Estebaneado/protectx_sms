package com.example.demo.model

import jakarta.persistence.*

@Entity
@Table(name = "roles")
data class Rol(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false, unique = true, length = 50)
    var nombre: String = ""
)
