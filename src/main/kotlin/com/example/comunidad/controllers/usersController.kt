package com.example.comunidad.controllers

import org.springframework.web.bind.annotation.*
import com.example.comunidad.models.dataClass.User
import com.example.comunidad.models.DTO.DTOcrearUser
import com.example.comunidad.services.UserService

@RestController
@RequestMapping("/usuarios")
class UserController(
	private val userService: UserService
) {

	// Listar todos los usuarios
	@GetMapping
	fun listarUsuarios(): List<User> {
		return userService.listarUsuarios()
	}

	// Buscar usuario por id o email (con regex en la ruta)
	@GetMapping("/{id:.+}")
	fun buscarUsuarios(@PathVariable id: String): List<User> {
		return userService.buscarUsuario(id)
	}


	// Crear usuario
	@PostMapping
	fun crearUsuario(@RequestBody user: DTOcrearUser) {
		userService.crearUsuario(user)
	}
}
