package com.example.comunidad.controllers

import org.springframework.web.bind.annotation.*
import com.example.comunidad.models.dataClass.UserStatus

@RestController
@RequestMapping("/user-status")
class UserStatusController {
	@GetMapping
	fun listarUserStatus(): List<UserStatus> {
		return emptyList()
	}

	// API BUSCAR USER STATUS
	@GetMapping("/id:.+")
	fun buscarUserStatus(@PathVariable id: Long): UserStatus? {
		return null
	}

	@PostMapping
	fun crearUserStatus(@RequestBody userStatus: UserStatus): UserStatus {
		return userStatus
	}

	@PatchMapping("/{id}")
	fun actualizarUserStatus(@PathVariable id: Long, @RequestBody userStatus: UserStatus): UserStatus {
		return userStatus
	}
}