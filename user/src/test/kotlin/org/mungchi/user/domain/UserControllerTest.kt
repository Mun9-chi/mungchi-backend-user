import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import org.mungchi.user.controller.UserController
import org.mungchi.user.domain.user.Profile
import org.mungchi.user.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.http.ResponseEntity
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import java.util.Date

class ProfileControllerTest : StringSpec({

    "사용자의 정보를 정상적으로 조회할때 200을 반환한다." {

        // Given
        val userId = 1L
        val expectedProfile = Profile(
            userName = "SEONJUN",
            nickName = "sj",
            imageUrl = "https://example.com/asdf.jpg",
            following = 100,
            follower = 150,
            description = "good",
            createAt = Date(),
            updatedAt = Date()
        )
        val userService = mockk<UserService> {
            every { getUserProfileById(userId) } returns expectedProfile
        }

        val userController = UserController(userService)

        // When
        val result: ResponseEntity<Profile> = userController.getProfileById(userId)

        // Then
        result.statusCode shouldBe HttpStatus.OK
        result.body shouldBe expectedProfile
    }

    "사용자의 정보를 정상적으로 조회할때 200를 반환한다." {
        val userId = 1L
        val expectedProfile = Profile(
            userName = "seonjun",
            nickName = "sj",
            imageUrl = "https://example.com/asdf.jpg",
            following = 100,
            follower = 150,
            description = "good",
            createAt = Date(),
            updatedAt = Date()
        )

        // Given
        val userService = mockk<UserService> {
            every { getUserProfileById(userId) } returns expectedProfile
        }

        val userController = UserController(userService)

        val mockMvc = MockMvcBuilders.standaloneSetup(userController).build()

        // When
        mockMvc.perform(
            get("/user/$userId/profile")
                .contentType(APPLICATION_JSON)
        )
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.userName").value("seonjun"))
            .andExpect(jsonPath("$.nickName").value("sj"))
            .andExpect(jsonPath("$.following").value(100))
            .andExpect(jsonPath("$.follower").value(150))
            .andExpect(jsonPath("$.description").value("good"))
    }
})
