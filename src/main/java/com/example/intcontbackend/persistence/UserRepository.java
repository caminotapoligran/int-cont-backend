package com.example.intcontbackend.persistence;

import com.example.intcontbackend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

interface UserRepository extends JpaRepository<User, Long> {
}
