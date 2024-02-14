package org.mungchi.user.domain.user

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.util.Date


@Embeddable
class Profile(

    @Column
    val userName : String,

    @Column
    val nickName: String,

    @Column
    val imageUrl: String,

    @Column
    val following: Int,

    @Column
    val follower: Int,

    @Column
    val description: String,

    @Column
    val createAt: Date,

    @Column
    val updatedAt: Date
) {


}
