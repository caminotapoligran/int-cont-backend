package com.example.intcontbackend.persistence;

import com.example.intcontbackend.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

interface CategoryRepository extends JpaRepository<Category, Long> {
}
