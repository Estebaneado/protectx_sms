package com.example.comunidad.controllers

import org.springframework.web.bind.annotation.*
import com.example.comunidad.models.dataClass.Rol

@RestController
@RequestMapping("/roles")
class RolController {
	@GetMapping
	fun listarRoles(): List<Rol> {
		return emptyList()
	}
// API BUSCAR ROLES
	@GetMapping("/id:.+")
	fun buscarRoles(@PathVariable id: Long): Rol? {
		return null
	}

	@PostMapping
	fun crearRol(@RequestBody rol: Rol): Rol {
		return rol
	}

	@PatchMapping("/{id}")
	fun actualizarRol(@PathVariable id: Long, @RequestBody rol: Rol): Rol {
		return rol
	}
}