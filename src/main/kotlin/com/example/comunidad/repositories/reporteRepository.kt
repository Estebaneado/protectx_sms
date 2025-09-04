package com.example.comunidad.repositories
import com.example.comunidad.models.dataClass.User
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class UsuarioRepository(private val jdbcTemplate: JdbcTemplate) {

        fun crear(usuario: User, hashedPassword: String): Int {
        val sql = """
                INSERT INTO users (
                    nombresCompletos, email, contrasena, idrole, iduserStatus
                ) VALUES (?, ?, ?, ?)
            """
        return jdbcTemplate.update(
            sql,
            usuario.nombresCompletos,
            usuario.email,
            usuario.idrole,
            hashedPassword,
            usuario.idrole,
            usuario.iduserStatus,
        )
    }


    }

    fun editarUsuario(dto: UserUpdateDTO, id: String): Int {
        val sql = """
        UPDATE usuarios u
        SET 
            u.nombreCompleto = COALESCE(?, u.nombreCompleto),
            u.numContacto = COALESCE(?, u.numContacto),
            u.direccionResidencia = COALESCE(?, u.direccionResidencia)
            WHERE u.email = ? OR u.documentoIdentidad = ?
    """
        return jdbcTemplate.update(
