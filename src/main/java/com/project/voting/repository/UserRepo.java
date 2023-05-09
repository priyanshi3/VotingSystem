package com.project.voting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.voting.entity.Login;

public interface UserRepo extends JpaRepository<Login, Integer> {

}
