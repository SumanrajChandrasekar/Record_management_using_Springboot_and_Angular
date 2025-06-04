package com.project.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Student;
import com.project.service.StudentService;

@RestController
@RequestMapping("/v0")
@CrossOrigin("*")
public class StudentController {
	
	private final StudentService studentservice;
	
	public StudentController (StudentService studentservice) {
		this.studentservice=studentservice;
	}
	
	@PostMapping("/students")
    public ResponseEntity<String> createStudent(@RequestBody Student student) {
		 System.out.println("Received Student: " + student);
        return studentservice.postStudent(student);
	}
        
        @GetMapping("/getstudents")
    	public List<Student> getAllStudents(){
    		return studentservice.getAllStudent();
	}
        
        @GetMapping("/student/{id}")
        public ResponseEntity<?> getStudentById(@PathVariable int id) {
            Student student = studentservice.getStudentById(id);
            if (student != null) {
                return ResponseEntity.ok(student);
            } else {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("Student not found with ID: " + id);
            }
        }
        
       
        @PutMapping("/student/{id}")
        public ResponseEntity<String> updateStudent(@PathVariable int id, @RequestBody Student student) {
            return studentservice.updateStudent(id, student);
        }
        
        @DeleteMapping("/students/{id}")
        public ResponseEntity<String> deleteStudent(@PathVariable int id) {
            studentservice.deleteStudent(id);
            return ResponseEntity.ok("Student deleted successfully");
        }
}








