package com.example.intcontbackend.persistence;

import com.example.intcontbackend.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OperationRepositoryTest {

    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    private UserTypeRepository userTypeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private OperationTypeRepository operationTypeRepository;

    @Test
    public void whenInsert_shouldChangeUserCount() {
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

        Property property = propertyRepository.save(Property.builder()
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
                .build());

        OperationType operationType = operationTypeRepository.save(OperationType.builder()
                .name("sample")
                .build());

        Operation operation = Operation.builder()
                .date(Date.valueOf(LocalDate.MIN))
                .property(property)
                .operationType(operationType)
                .build();

        // When
        Operation savedOperation = operationRepository.save(operation);

        // Then
        assertNotNull(savedOperation);
        assertTrue(operationRepository.count() == 1);
    }
}
