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

import com.example.demo.Entity.Student;
import com.example.demo.Service.StudentService;


@RestController
@RequestMapping("/")
public class StudentContorller {
	@Autowired
	StudentService studentService;
	
	@GetMapping
    public List<Student> getStudentList () {
		List<Student> studentList = studentService.getStudentList();
        return studentList;
    }
	
	@PostMapping
    public void addStudent (@RequestBody Student student) {
        studentService.addStudent(student);
    }
	
	@DeleteMapping("/{id}")
    public void deleteStudent (@PathVariable Integer id) {
        studentService.deleteStudent(id);
    }
	
	@GetMapping("/Quantity")
    public int getStudentQuantity () {
        return studentService.getStudentQuantity();
    }
}
