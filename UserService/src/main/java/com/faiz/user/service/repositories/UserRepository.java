package com.faiz.user.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.faiz.user.service.entities.User;

public interface UserRepository extends JpaRepository<User, String>{

}
