package com.example.demo.Dao.DaoStudent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Entity.EntityStudent.Student;

public interface StudentDao extends JpaRepository<Student, Integer>{
	@Query(nativeQuery = true, value = "SELECT COUNT(*) FROM studentt")
    int Quantity();
}
