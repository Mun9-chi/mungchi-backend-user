package org.mungchi.user.service

import lombok.RequiredArgsConstructor
import org.mungchi.user.domain.user.Profile
import org.mungchi.user.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
@RequiredArgsConstructor
class UserService(private val userRepository: UserRepository) {

    fun getUserProfileById(userId: Long): Profile? {
        return userRepository.findById(userId).map { it.profile }.orElse(null)
    }
}
