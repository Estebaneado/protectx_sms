package com.example.demo.controller

import com.example.demo.model.Rol
import com.example.demo.service.RolService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/roles")
class RolController(
    private val rolService: RolService
) {

    @GetMapping
    fun getAllRoles(): ResponseEntity<List<Rol>> =
        ResponseEntity.ok(rolService.getAllRoles())

    @GetMapping("/{id}")
    fun getRolById(@PathVariable id: Long): ResponseEntity<Rol> {
        val rol = rolService.getRolById(id)
        return if (rol != null) ResponseEntity.ok(rol)
        else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createRol(@RequestBody rol: Rol): ResponseEntity<Rol> =
        ResponseEntity.ok(rolService.createRol(rol))

    @PutMapping("/{id}")
    fun updateRol(@PathVariable id: Long, @RequestBody rol: Rol): ResponseEntity<Rol> {
        val updatedRol = rolService.updateRol(id, rol)
        return if (updatedRol != null) ResponseEntity.ok(updatedRol)
        else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteRol(@PathVariable id: Long): ResponseEntity<Void> {
        return if (rolService.deleteRol(id)) ResponseEntity.noContent().build()
        else ResponseEntity.notFound().build()
    }
}
