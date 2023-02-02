package com.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Entity.Student;


public interface StudentDao  extends JpaRepository<Student, Integer>{
	@Query(nativeQuery = true, value = "SELECT COUNT(*) FROM studentt")
    int dishQuantity();
}
