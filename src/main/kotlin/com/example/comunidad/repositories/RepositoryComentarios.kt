package com.example.comunidad.repositories
import com.example.comunidad.models.DTO.CrearComentarioDTO
import com.example.comunidad.models.DTO.VerComentarioUserDTO
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class ComentariosRepository(private val jdbcTemplate: JdbcTemplate) {

    // Listar todos los comentarios con info del usuario
    fun listarComentarios(): List<VerComentarioUserDTO> {
        val sql = """
            SELECT c.id,
                   c.comentario,
                   c.fechaCreacionComentario,
                   c.idUser,
                   u.nombresCompletos AS nombreUsuario,
                   u.email AS emailUsuario
            FROM comentariosComunidad c
            LEFT JOIN users u ON c.idUser = u.id
        """
        return jdbcTemplate.query(sql) { rs, _ ->
            VerComentarioUserDTO(
                id = rs.getLong("id"),
                comentario = rs.getString("comentario"),
                fechaCreacionComentario = rs.getTimestamp("fechaCreacionComentario")?.toLocalDateTime(),
                idUser = rs.getLong("idUser").takeIf { !rs.wasNull() },
                nombreUsuario = rs.getString("nombreUsuario"),
                emailUsuario = rs.getString("emailUsuario")
            )
        }
    }

    // Buscar comentarios por email de usuario
    fun buscarComentariosPorEmail(email: String): List<VerComentarioUserDTO> {
        val sql = """
            SELECT c.id,
                   c.comentario,
                   c.fechaCreacionComentario,
                   c.idUser,
                   u.nombresCompletos AS nombreUsuario,
                   u.email AS emailUsuario
            FROM comentariosComunidad c
            JOIN users u ON c.idUser = u.id
            WHERE u.email = ?
        """
        return jdbcTemplate.query(sql, arrayOf(email)) { rs, _ ->
            VerComentarioUserDTO(
                id = rs.getLong("id"),
                comentario = rs.getString("comentario"),
                fechaCreacionComentario = rs.getTimestamp("fechaCreacionComentario")?.toLocalDateTime(),
                idUser = rs.getLong("idUser").takeIf { !rs.wasNull() },
                nombreUsuario = rs.getString("nombreUsuario"),
                emailUsuario = rs.getString("emailUsuario")
            )
        }
    }

    // Crear un comentario usando DTO
    fun crearComentario(dto: CrearComentarioDTO): Int {
        val sql = """
            INSERT INTO comentariosComunidad (comentario, idUser)
            VALUES (?, ?)
        """
        return jdbcTemplate.update(sql, dto.comentario, dto.idUser)
    }
}
