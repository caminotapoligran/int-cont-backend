package com.example.intcontbackend.persistence;

import com.example.intcontbackend.domain.OperationType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OperationTypeRepositoryTest {

    @Autowired
    private OperationTypeRepository operationTypeRepository;

    @Test
    public void whenInsert_shouldChangeUserCount(){
        // Given
        OperationType operationType = OperationType.builder()
                .name("sample")
                .build();

        // When
        OperationType savedOperationType = operationTypeRepository.save(operationType);

        // Then
        assertNotNull(savedOperationType);
        assertTrue(operationTypeRepository.count() == 1);
    }
}
