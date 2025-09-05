package com.example.comunidad.controllers

import org.springframework.web.bind.annotation.*
import com.example.comunidad.models.dataClass.User

@RestController
@RequestMapping("/usuarios")
class UserUpdateController {
	@GetMapping
	fun listarUsuarios(): List<User> {
		return emptyList()
	}

	// API BUSCAR USUARIOS
	@GetMapping("/id:.+")
	fun buscarUsuarios(@PathVariable id: Long): User? {
		return null
	}

	@PostMapping
	fun crearUsuario(@RequestBody user: User): User {
		return user
	}

	@PatchMapping("/{id}")
	fun actualizarUsuario(@PathVariable id: Long, @RequestBody user: User): User {
		return user
	}

	@PatchMapping("/{id}/activar")
	fun activarUsuario(@PathVariable id: Long): String {
		return "Usuario activado"
	}

	@PatchMapping("/{id}/desactivar")
	fun desactivarUsuario(@PathVariable id: Long): String {
		return "Usuario desactivado"
	}
}