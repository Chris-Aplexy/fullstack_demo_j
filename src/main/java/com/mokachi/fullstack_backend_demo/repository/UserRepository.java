package com.mokachi.fullstack_backend_demo.repository;

import com.mokachi.fullstack_backend_demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
