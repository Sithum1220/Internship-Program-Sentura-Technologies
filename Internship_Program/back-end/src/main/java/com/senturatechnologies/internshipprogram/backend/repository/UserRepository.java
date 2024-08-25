package com.senturatechnologies.internshipprogram.backend.repository;

import com.senturatechnologies.internshipprogram.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}