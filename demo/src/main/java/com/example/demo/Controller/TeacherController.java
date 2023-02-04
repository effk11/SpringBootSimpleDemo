package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.EntityTeacher.Teacher;
import com.example.demo.Service.TeacherService;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
	@Autowired
	TeacherService teacherService;
	
	@GetMapping
    public List<Teacher> getTeacherList () {
		List<Teacher> teacherList = teacherService.getTeacherList();
        return teacherList;
    }
	
	@PostMapping
    public void addTeacher (@RequestBody Teacher teacher) {
        teacherService.addTeacher(teacher);
    }
	
	@DeleteMapping("/{id}")
    public void deleteTeacher (@PathVariable Integer id) {
        teacherService.deleteTeacher(id);
    }
	
	@GetMapping("/Quantity")
    public int getStudentQuantity () {
        return teacherService.getTeacherQuantity();
    }
}
