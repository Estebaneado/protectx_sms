package com.example.comunidad.repositories

import com.example.comunidad.models.DTO.DTOcrearUser
import com.example.comunidad.models.dataClass.User
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class AuthRepository(private val jdbcTemplate: JdbcTemplate) {

    fun buscarPorEmail(email: String): DTOcrearUser? {
        val sql = "SELECT * FROM users WHERE email = ?"
        return jdbcTemplate.query(sql, { rs, _ ->
            DTOcrearUser(
                nombresCompletos = rs.getString("nombresCompletos"),
                email = rs.getString("email"),
                contrasena = rs.getString("contrasena"),
                idrole = rs.getLong("idrole"),
                iduserStatus = rs.getLong("iduserStatus")
            )
        }, email).firstOrNull()
    }
}
