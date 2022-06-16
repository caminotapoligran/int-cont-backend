package com.example.intcontbackend.persistence;

import com.example.intcontbackend.domain.UserType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserTypeRepositoryTest {

    @Autowired
    UserTypeRepository userTypeRepository;

    @Before
    public void setup() {
        userTypeRepository.deleteAll();
    }

    @Test
    public void whenInsert_shouldChangeCount() {
        // Given
        UserType userType = UserType.builder()
                .name("sample")
                .role("sample")
                .build();

        // when
        UserType savedUserType = userTypeRepository.save(userType);

        // Then
        assertNotNull(savedUserType);
        assertTrue(userTypeRepository.count() == 1);
    }

    @Test
    public void whenDelete_shouldChangeCount() {
        // Given
        UserType userType = UserType.builder()
                .name("sample")
                .role("sample")
                .build();
        UserType savedUserType = userTypeRepository.save(userType);

        // when
        userTypeRepository.delete(savedUserType);

        // Then
        assertTrue(userTypeRepository.count() == 0);
    }

}
