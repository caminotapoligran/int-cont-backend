package com.example.intcontbackend.persistence;

import com.example.intcontbackend.domain.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

interface OperationRepository extends JpaRepository<Operation, Long> {
}
