package com.example.intcontbackend.persistence;

import com.example.intcontbackend.domain.Category;
import com.example.intcontbackend.domain.Property;
import com.example.intcontbackend.domain.User;
import com.example.intcontbackend.domain.UserType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PropertyRepositoryTest {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private UserTypeRepository userTypeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void whenInsert_shouldChangeUserCount(){
        // Given
        UserType userType = userTypeRepository.save(UserType.builder()
                .name("sample")
                .role("sample")
                .build());

        User user = userRepository.save(User.builder()
                .type(userType)
                .name("sample")
                .lastName("sample")
                .username("sample")
                .password("sample")
                .email("sample")
                .phone("sample")
                .address("sample")
                .isAdmin(false)
                .build());

        Category category = categoryRepository.save(Category.builder()
                .name("sample")
                .description("sample")
                .build());

        Property property = Property.builder()
                .name("sample")
                .description("sample")
                .price(0D)
                .user(user)
                .category(category)
                .city("sample")
                .neighborhood("sample")
                .rooms(0L)
                .bathrooms(0L)
                .parking(0L)
                .stratum(0L)
                .area("sample")
                .createdAt(Date.valueOf(LocalDate.MIN))
                .build();

        // When
        Property savedProperty = propertyRepository.save(property);

        // Then
        assertNotNull(savedProperty);
        assertTrue(propertyRepository.count() == 1);
    }
}
