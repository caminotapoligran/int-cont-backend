package com.example.intcontbackend.persistence;

import com.example.intcontbackend.domain.User;
import com.example.intcontbackend.domain.UserType;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    private User sampleUser;
    private UserType sampleUserType;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserTypeRepository userTypeRepository;

    @Before
    public void setup() {
        sampleUserType = UserType.builder()
                .role("sample")
                .name("sample")
                .build();
        sampleUser = User.builder()
                .type(sampleUserType)
                .name("sample")
                .lastName("sample")
                .username("sample")
                .password("sample")
                .email("sample@sample.com")
                .phone("sample")
                .password("sample")
                .address("sample")
                .isAdmin(false)
                .build();
    }

    @Test
    public void whenInsertUser_shouldChangeUserCount() {
        // Given
        userTypeRepository.save(sampleUserType);
        User savedEntity = userRepository.save(sampleUser);

        // When
        Long userCount = userRepository.count();

        // Then
        assertNotNull(savedEntity);
        assertNotNull(userCount);
        assertTrue(userCount == 1L);

    }

    @Test
    public void whenDeleteUser_shouldChangeUserCount() {
        // Given
        userRepository.delete(sampleUser);

        // When
        Long userCount = userRepository.count();

        // Then
        assertNotNull(userCount);
        assertTrue(userCount == 0L);

    }

    @Test
    public void whenUpdateUser_shouldNotChangeUserCount() {
        // Given
        userTypeRepository.save(sampleUserType);
        User savedEntity = userRepository.save(sampleUser);
        savedEntity.setName("sample 2");
        User savedEntity2 = userRepository.save(savedEntity);

        // When
        Long userCount = userRepository.count();

        // Then
        assertNotNull(savedEntity);
        assertNotNull(savedEntity2);
        assertTrue(userCount == 1L);

    }
}
