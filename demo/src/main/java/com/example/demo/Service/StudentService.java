package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.DaoStudent.StudentDao;
import com.example.demo.Entity.EntityStudent.Student;

import jakarta.transaction.Transactional;

@Service
public class StudentService {
	@Autowired
	StudentDao studentDao;
	
	public List<Student> getStudentList(){
		return studentDao.findAll();
	}
	
	public void addStudent(Student student){
		studentDao.save(student);
	}
	
	public void deleteStudent(Integer id){
		studentDao.deleteById(id);
	}
	
	public int getStudentQuantity() {
		return studentDao.Quantity();
	}
}
