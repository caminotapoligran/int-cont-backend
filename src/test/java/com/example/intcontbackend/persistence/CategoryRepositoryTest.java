package com.example.intcontbackend.persistence;

import com.example.intcontbackend.domain.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void whenInsert_shouldChangeUserCount(){
        // Given
        Category category = Category.builder()
                .name("sample")
                .description("sample")
                .build();

        // When
        Category savedCategory = categoryRepository.save(category);

        // Then
        assertNotNull(savedCategory);
        assertTrue(categoryRepository.count()==1);
    }
}
