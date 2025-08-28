package com.uday.task3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uday.task3.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
