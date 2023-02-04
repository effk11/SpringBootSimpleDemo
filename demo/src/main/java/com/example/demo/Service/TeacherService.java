package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.DaoTeacher.TeacherDao;
import com.example.demo.Entity.EntityTeacher.Teacher;

@Service
public class TeacherService {
	@Autowired
	TeacherDao teacherDao;
	
	public List<Teacher> getTeacherList(){
		return teacherDao.findAll();
	}
	
	public void addTeacher(Teacher teacher){
		teacherDao.save(teacher);
	}
	
	public void deleteTeacher(Integer id){
		teacherDao.deleteById(id);
	}
	
	public int getTeacherQuantity() {
		return teacherDao.Quantity();
	}
}
