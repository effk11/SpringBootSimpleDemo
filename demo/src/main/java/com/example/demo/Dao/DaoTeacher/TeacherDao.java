package com.example.demo.Dao.DaoTeacher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Entity.EntityTeacher.Teacher;

public interface TeacherDao extends JpaRepository<Teacher, Integer>{
	@Query(nativeQuery = true, value = "SELECT COUNT(*) FROM teacher")
    int Quantity();
}
