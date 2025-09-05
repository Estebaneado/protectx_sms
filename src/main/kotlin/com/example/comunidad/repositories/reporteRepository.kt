package com.example.comunidad.repositories

import com.example.comunidad.models.dataClass.Reporte
import com.example.comunidad.models.DTO.CrearReporteDTO
import com.example.comunidad.models.DTO.ReporteConUsuarioDTO

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class ReporteRepository(private val jdbcTemplate: JdbcTemplate) {

    fun listarReportes(): List<Reporte> {
        val sql = "SELECT * FROM reportes"
        return jdbcTemplate.query(sql) { rs, _ ->
            Reporte(
                categoriaReporte = rs.getString("categoriaReporte"),
                quejaReporte = rs.getString("quejaReporte"),
                iduser = rs.getLong("iduser"),
                fechaCreacionR = rs.getTimestamp("fechaCreacionR").toLocalDateTime()
            )
        }
    }

    fun buscarReportePorEmail(email: String): List<ReporteConUsuarioDTO> {
        val sql = """
        SELECT r.idreporte,
               r.categoriaReporte,
               r.quejaReporte,
               r.fechaCreacionR,
               u.nombresCompletos,
               u.email
        FROM reportes r
        JOIN users u ON r.iduser = u.id
        WHERE u.email = ?
    """
        return jdbcTemplate.query(sql, arrayOf(email)) { rs, _ ->
            ReporteConUsuarioDTO(
                idReporte = rs.getLong("idreporte"),
                categoriaReporte = rs.getString("categoriaReporte"),
                quejaReporte = rs.getString("quejaReporte"),
                fechaCreacionR = rs.getTimestamp("fechaCreacionR")?.toLocalDateTime(),
                nombreUsuario = rs.getString("nombresCompletos"),
                emailUsuario = rs.getString("email")
            )
        }
    }



    fun crearReporte(dto: CrearReporteDTO): Int {
        val sql = """
            INSERT INTO reportes (
                categoriaReporte,
                quejaReporte,
                iduser
            ) VALUES (?, ?, ?)
        """
        return jdbcTemplate.update(
            sql,
            dto.categoriaReporte,
            dto.quejaReporte,
            dto.iduser
        )
    }
}
