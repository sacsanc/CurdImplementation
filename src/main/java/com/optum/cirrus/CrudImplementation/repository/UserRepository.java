package com.optum.cirrus.CrudImplementation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.optum.cirrus.CrudImplementation.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
