package com.neerajkumar.project.springbootrestapi.repositories;

import com.neerajkumar.project.springbootrestapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
