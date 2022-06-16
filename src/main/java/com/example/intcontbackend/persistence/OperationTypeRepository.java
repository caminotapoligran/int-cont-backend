package com.example.intcontbackend.persistence;

import com.example.intcontbackend.domain.OperationType;
import org.springframework.data.jpa.repository.JpaRepository;

interface OperationTypeRepository extends JpaRepository<OperationType, Long> {
}
