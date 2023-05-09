package com.project.voting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.voting.entity.StudentVoter;

public interface StuRepo extends JpaRepository<StudentVoter, Integer> {

}
