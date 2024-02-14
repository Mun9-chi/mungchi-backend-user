package org.mungchi.user.domain.user

import jakarta.persistence.Column
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import lombok.Getter
import lombok.RequiredArgsConstructor

@Getter
@RequiredArgsConstructor
@Entity
class User(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,

    @Column
    val socialId: Int,

    @Enumerated(value = EnumType.STRING)
    val socialType: SocialType,

    @Embedded
    val profile: Profile
) {

}

