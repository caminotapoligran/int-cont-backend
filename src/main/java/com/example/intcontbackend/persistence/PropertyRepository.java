package com.example.intcontbackend.persistence;

import com.example.intcontbackend.domain.Property;
import org.springframework.data.jpa.repository.JpaRepository;

interface PropertyRepository extends JpaRepository<Property, Long> {
}
