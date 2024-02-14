package org.mungchi.user.controller

import org.mungchi.user.domain.user.Profile
import org.mungchi.user.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/user")
@RestController
class UserController(private val userService: UserService) {

    @GetMapping("/{userId}/profile")
    fun getProfileById(@PathVariable userId: Long): ResponseEntity<Profile> {
        val userProfile = userService.getUserProfileById(userId)
        return ResponseEntity.ok(userProfile)
    }
}
