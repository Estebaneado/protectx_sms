package com.example.comunidad.controllers

import org.springframework.web.bind.annotation.*
import com.example.comunidad.models.dataClass.Solicitud

@RestController
@RequestMapping("/solicitudes")
class SolicitudController {
	@GetMapping
	fun listarSolicitudes(): List<Solicitud> {
		return emptyList()
	}

	// API BUSCAR SOLICITUDES
	@GetMapping("/id:.+")
	fun buscarSolicitudes(@PathVariable id: Long): Solicitud? {
		return null
	}

	@PostMapping
	fun crearSolicitud(@RequestBody solicitud: Solicitud): Solicitud {
		return solicitud
	}

	@PatchMapping("/{id}")
	fun actualizarSolicitud(@PathVariable id: Long, @RequestBody solicitud: Solicitud): Solicitud {
		return solicitud
	}
}