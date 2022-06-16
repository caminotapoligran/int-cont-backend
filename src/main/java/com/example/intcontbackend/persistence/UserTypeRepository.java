package com.example.intcontbackend.persistence;

import com.example.intcontbackend.domain.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

interface UserTypeRepository extends JpaRepository<UserType, Long> {
}
