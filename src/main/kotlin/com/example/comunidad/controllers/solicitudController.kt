package com.example.comunidad.controllers

import com.example.comunidad.models.dataClass.Solicitud
import com.example.comunidad.services.SolicitudService
import org.springframework.web.bind.annotation.*
import com.example.comunidad.models.DTO.SolicitudConUsuarioDTO
import com.example.comunidad.models.DTO.CrearSolicitudDTO



@RestController
@RequestMapping("/solicitudes")
class SolicitudController(private val solicitudService: SolicitudService) {

	@GetMapping
	fun listarSolicitudes(): List<Solicitud> {
		return solicitudService.listarSolicitudes()
	}

	// Buscar por idsolicitud o iduser
	@GetMapping("/{email:.+}")
	fun buscarSolicitudPorEmail(@PathVariable email: String): List<SolicitudConUsuarioDTO> {
		return solicitudService.buscarSolicitudPorEmail(email)
	}

	@PostMapping
	fun crearSolicitud(@RequestBody dto: CrearSolicitudDTO): String {
		solicitudService.crearSolicitud(dto)
		return "Solicitud creada con éxito"
	}


}
