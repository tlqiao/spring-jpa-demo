package com.example.springjpademo.jpademo.repository;

import com.example.springjpademo.jpademo.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
