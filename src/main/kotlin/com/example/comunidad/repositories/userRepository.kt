package com.example.comunidad.repositories

import com.example.comunidad.models.dataClass.User
import com.example.comunidad.models.DTO.DTOcrearUser
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class UserRepository(private val jdbcTemplate: JdbcTemplate) {

    fun listarUsuarios(): List<User> {
        val sql = "SELECT * FROM users"
        return jdbcTemplate.query(sql) { rs, _ ->
            User(
                id = rs.getLong("id"),
                nombresCompletos = rs.getString("nombresCompletos"),
                email = rs.getString("email"),
                idrole = rs.getLong("idrole"),
                iduserStatus = rs.getLong("iduserStatus")
            )
        }
    }

    fun crearUsuario(dto: DTOcrearUser, hashedPassword: String): Int {
        val sql = """
            INSERT INTO users (
                nombresCompletos,
                email,
                contrasena,
                idrole,
                iduserStatus
            ) VALUES (?, ?, ?, ?, ?)
        """

        return jdbcTemplate.update(
            sql,
            dto.nombresCompletos,
            dto.email,
            hashedPassword,
            dto.idrole,
            dto.iduserStatus
        )
    }

    fun buscarUsuario(id: String): List<User> {
        val sql = "SELECT * FROM users WHERE email = ?"
        return jdbcTemplate.query(sql, arrayOf(id)) { rs, _ ->
            User(
                id = rs.getLong("id"),
                nombresCompletos = rs.getString("nombresCompletos"),
                email = rs.getString("email"),
                idrole = rs.getLong("idrole"),
                iduserStatus = rs.getLong("iduserStatus")
            )
        }
    }
}
