package com.example.comunidad.repositories

import com.example.comunidad.models.dataClass.Solicitud
import com.example.comunidad.models.DTO.SolicitudConUsuarioDTO
import com.example.comunidad.models.DTO.CrearSolicitudDTO


import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class SolicitudRepository(private val jdbcTemplate: JdbcTemplate) {

    fun listarSolicitudes(): List<Solicitud> {
        val sql = "SELECT * FROM solicitud"
        return jdbcTemplate.query(sql) { rs, _ ->
            Solicitud(
                categoriaSolicitud = rs.getString("categoriaSolicitud"),
                descripcion = rs.getString("descripcion"),
                iduser = rs.getLong("iduser")
            )
        }
    }

    fun buscarSolicitudPorEmail(email: String): List<SolicitudConUsuarioDTO> {
        val sql = """
        SELECT s.idsolicitud,
               s.categoriaSolicitud,
               s.descripcion,
               s.fechaCreacionS,
               u.id,
               u.email
        FROM solicitud s
        JOIN users u ON s.iduser = u.id
        WHERE u.email = ?
    """
        return jdbcTemplate.query(sql, arrayOf(email)) { rs, _ ->
            SolicitudConUsuarioDTO(
                idSolicitud = rs.getLong("idsolicitud"),
                categoriaSolicitud = rs.getString("categoriaSolicitud"),
                descripcion = rs.getString("descripcion"),
                fechaCreacionS = rs.getTimestamp("fechaCreacionS")?.toLocalDateTime(),
                idUsuario = rs.getLong("id"),
                emailUsuario = rs.getString("email")
            )
        }
    }


    fun crearSolicitud(dto: CrearSolicitudDTO): Int {
        val sql = """
        INSERT INTO solicitud (categoriaSolicitud, descripcion, iduser)
        VALUES (?, ?, ?)
    """
        return jdbcTemplate.update(sql,
            dto.categoriaSolicitud,
            dto.descripcion,
            dto.iduser
        )
    }



}
