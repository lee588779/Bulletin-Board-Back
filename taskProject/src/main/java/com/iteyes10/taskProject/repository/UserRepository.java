package com.iteyes10.taskProject.repository;

import com.iteyes10.taskProject.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
